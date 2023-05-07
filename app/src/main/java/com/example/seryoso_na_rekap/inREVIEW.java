package com.example.seryoso_na_rekap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seryoso_na_rekap.Adapter.myAdapter;
import com.example.seryoso_na_rekap.Helper.DBHelper;
import com.google.android.material.search.SearchView;

import java.util.ArrayList;

public class inREVIEW extends AppCompatActivity {
ImageButton Back;
ImageButton music;
RecyclerView recyclerView;
CardView cardView;
ArrayList<String> title, notes;
ImageView pin;
DBHelper DB;
myAdapter adapter;
TextView timer_txt;
ImageButton add_btn;
ImageButton timer;
int i = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_review);

        //buttons
        Back = findViewById(R.id.backbotton);
        music = findViewById(R.id.music_btn);
        recyclerView = findViewById(R.id.rec_view);
        timer_txt = findViewById(R.id.txt_timer);
        add_btn = findViewById(R.id.add_btn);
        timer = findViewById(R.id.timer_btn_id);
        cardView = findViewById(R.id.notes_container);

        //recyclerview and database
        DB = new DBHelper(this);
        title = new ArrayList<>();
        notes = new ArrayList<>();
        recyclerView = findViewById(R.id.rec_view);
        adapter = new myAdapter(this, title,notes,pin);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DisplayData();
        //UpdateData();

        //listeners
        Back.setOnClickListener(view -> {
            Intent intent = new Intent(inREVIEW.this, MainActivity.class);
            startActivity(intent);

        });

        add_btn.setOnClickListener(view -> {
            Intent intent = new Intent(inREVIEW.this, for_creating_notes.class);
            startActivity(intent);

        });

        //papunta sa music
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inREVIEW.this, Music.class);
                startActivity(intent);
                finish();
            }
        });

        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cardView = findViewById(R.id.notes_container);
                registerForContextMenu(cardView);
                return false;
            }
        });

    }

    private void DisplayData() {

    }
/*
    private void UpdateData() {
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    } */


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.longclick_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pin_id:
                Toast.makeText(this, "pinned", Toast.LENGTH_SHORT).show();
                return true;
            /*case R.id.delete_id:
                DB.deletedata(title.get(i),notes.get(i));
                return true;
            default:
                return super.onContextItemSelected(item);*/
        }

        return false;
    }

    public void cardView(View view) {

    }
}