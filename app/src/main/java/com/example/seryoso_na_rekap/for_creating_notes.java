package com.example.seryoso_na_rekap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.seryoso_na_rekap.Helper.DBHelper;

public class for_creating_notes extends AppCompatActivity {
ImageButton insert, back;
EditText title, notes;
DBHelper DB; 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_creating_notes);

        //buttons
        insert = findViewById(R.id.save);
        //update = findViewById(R.id.edit_btn);
        back = findViewById(R.id.back_btn);
        //edit texts
        title = findViewById(R.id.edittext_title);
        notes = findViewById(R.id.edittext_notes);
        
        //helper
        DB = new DBHelper(this);
        
        //on click listener
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(for_creating_notes.this, inREVIEW.class));
            }
        });
        
        //insert function
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(for_creating_notes.this, inREVIEW.class));

                String title_ = title.getText().toString();
                String notes_ = notes.getText().toString();


                Boolean check_insertdata = DB.insertuserData(title_, notes_);
                if(check_insertdata == true){
                    Toast.makeText(for_creating_notes.this, "saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(for_creating_notes.this, "not saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}