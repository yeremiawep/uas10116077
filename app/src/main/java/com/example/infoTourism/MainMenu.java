//10 Juni 2021 - 10116077 - Yeremia Wahyu - AKBul1


package com.example.infoTourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.infoTourism.R;

public class MainMenu extends AppCompatActivity {
    Button btnSignIn,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnSignIn =(Button)findViewById(R.id.btn_SignIn);
        btnSignUp = (Button)findViewById(R.id.btn_SignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn = new Intent(MainMenu.this,SignIn.class);
                startActivity(signIn);


            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainMenu.this,SignUp.class);
                startActivity(signUp);

            }
        });


    }
}
