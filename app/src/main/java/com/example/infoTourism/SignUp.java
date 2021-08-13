//10 Juni 2021 - 10116077 - Yeremia Wahyu - AKBul1


package com.example.infoTourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.infoTourism.Model.User;
import com.example.infoTourism.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText edtPhone,edtName,edtPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName =(MaterialEditText)findViewById(R.id.editname);
        edtPassword =(MaterialEditText)findViewById(R.id.editPassword);
        edtPhone =(MaterialEditText)findViewById(R.id.editphone);


        btnSignUp = (Button)findViewById(R.id.btn_SignUp);

        final FirebaseDatabase database =FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Mohon Tunggu");
                mDialog.show();
                mDialog.dismiss();


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                            mDialog.dismiss();

                            Toast.makeText(SignUp.this, "Phone Number Telah Terdaftar", Toast.LENGTH_SHORT).show();
                            mDialog.show();
                            mDialog.dismiss();


                        } else {
                            User user = new User(edtName.getText().toString(), edtPassword.getText().toString());
                            table_user.child(edtPhone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Sign up successfully !", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                            Intent homeIntent = new Intent(SignUp.this, SignIn.class);
                            Common.currentUser = user;
                            startActivity(homeIntent);
                            finish();
                            mDialog.dismiss();


                        }
                        mDialog.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                mDialog.dismiss();

            }
        });








    }
}





