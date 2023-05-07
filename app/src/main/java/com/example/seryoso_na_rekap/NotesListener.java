package com.example.seryoso_na_rekap;

import androidx.cardview.widget.CardView;

import com.example.seryoso_na_rekap.Model.Notes;

public interface NotesListener {
    void onCLick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
