//10 Juni 2021 - 10116077 - Yeremia Wahyu - AKBul1


package com.example.infoTourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.infoTourism.Maps.MainMapActivity;
import com.example.infoTourism.Model.Category;
import com.example.infoTourism.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class PlaceDetail extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference category;


    TextView txtName;
    TextView txtdescription;
    TextView txtfasilitas;
    TextView txtspesifikasi;
    ImageView category_image;
    FloatingActionButton btndetail;
    CollapsingToolbarLayout collapsingToolbarLayout;
    String categoryId = "";
    FirebaseRecyclerAdapter<Category, MenuViewHolder> adapter;

    Button btn_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placedetail);


        //Firebase
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Category");




                //Init View
                btndetail = (FloatingActionButton) findViewById(R.id.btndetail);
                txtName = (TextView) findViewById(R.id.kavling_name);
                txtdescription = (TextView) findViewById(R.id.kavling_description);
                  txtfasilitas = (TextView) findViewById(R.id.kavling_fasilitas);
                 txtspesifikasi = (TextView) findViewById(R.id.kavling_spesifikasi);
                category_image = (ImageView) findViewById(R.id.img_kavling);


                //Button Map
                btn_map = (Button) findViewById(R.id.btn_map);

                btn_map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(PlaceDetail.this, MainMapActivity.class);
                                startActivity(i);
                    }
                });

                //Akhir Button Map


                collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);

                if (getIntent() != null)
                    categoryId = getIntent().getStringExtra("CategoryId");
                if (!categoryId.isEmpty()) {

                    getdataCategory(categoryId);
                }

            }

            private void getdataCategory(String categoryId) {
                category.child(categoryId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        final Category category = dataSnapshot.getValue(Category.class);


                        //masukan gambar
                        Picasso.with(getBaseContext()).load(category.getImage())
                                .into(category_image);


                        collapsingToolbarLayout.setTitle(category.getNama());

                        txtName.setText(category.getNama());
                        txtdescription.setText(category.getDescription());
                        txtfasilitas.setText(category.getFasilitas());
                        txtspesifikasi.setText(category.getSpesifikasi());

                        FloatingActionButton fab = findViewById(R.id.btndetail);
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(category.getLinkWeb()));
                                startActivity(intent);
                            }

                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

}
    


