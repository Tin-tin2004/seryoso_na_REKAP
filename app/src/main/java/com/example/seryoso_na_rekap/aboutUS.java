package com.example.seryoso_na_rekap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class aboutUS extends AppCompatActivity {
ImageButton bck_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        bck_btn = findViewById(R.id.aboutus_backBtn);
        bck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(aboutUS.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}