//10 Juni 2021 - 10116077 - Yeremia Wahyu - AKBul1


package com.example.infoTourism;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infoTourism.Model.User;
import com.example.infoTourism.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;

public class SignIn extends AppCompatActivity {
    EditText edtPhone,edtPassword;
    Button btnmasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword = (MaterialAutoCompleteTextView)findViewById(R.id.editPassword);
        edtPhone  =(MaterialAutoCompleteTextView) findViewById(R.id.editphone);
        btnmasuk =(Button)findViewById(R.id.btn_masuk);


        final FirebaseDatabase database =FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");


        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog  = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Mohon Tunggu");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //jika user tidak punya akun di database

                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                            mDialog.dismiss();


                            //get user information

                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);

                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(SignIn.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignIn.this, MenuUtama.class);
                                Common.currentUser = user;
                                startActivity(intent);
                                finish();


                            } else {
                                Toast.makeText(SignIn.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                            }


                        }
                        else
                        {
                            Toast.makeText(SignIn.this, "User Tidak Ada", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });





    }
}
