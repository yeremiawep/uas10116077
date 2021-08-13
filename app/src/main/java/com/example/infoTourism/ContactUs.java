//10 Juni 2021 - 10116077 - Yeremia Wahyu - AKBul1


package com.example.infoTourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        FloatingActionButton fab = findViewById(R.id.btncall);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:yeremiawahyu009@gmail.com"));
                startActivity(intent);
            }
        });

        ImageButton ig = findViewById(R.id.btn_instagram);
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToig();
            }

            private void goToig() {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/jvnse_"));

                startActivity(browserIntent);

            }
        });

    }

}
