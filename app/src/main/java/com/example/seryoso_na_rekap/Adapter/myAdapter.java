package com.example.seryoso_na_rekap.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seryoso_na_rekap.Model.Notes;
import com.example.seryoso_na_rekap.NotesListener;
import com.example.seryoso_na_rekap.R;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder> {
    private Context context;
    List<Notes> list;
    NotesListener listener;
    private ArrayList title_id, notes_id;
    private ImageView pin;


    public myAdapter(Context context, ArrayList title_id, ArrayList notes_id, ImageView pin) {
        this.context = context;
        this.title_id = title_id;
        this.notes_id = notes_id;
        this.pin = pin;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_save_view,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.title_id.setText(list.get(position).getTitle());
        holder.title_id.setSelected(true);
        holder.notes_id.setText(list.get(position).getNotes());

        if(list.get(position).isPinned()){
         holder.pin.setImageResource(R.drawable.baseline_star_24);
        } else {
            holder.pin.setImageResource(0);

        }

        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCLick(list.get(holder.getAdapterPosition()));

            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
                return true;

            }
        });


    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title_id, notes_id;
        ImageView pin;
        CardView notes_container;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title_id = itemView.findViewById(R.id.txt_title);
            notes_id = itemView.findViewById(R.id.txt_notes);
            pin = itemView.findViewById(R.id.pin);
            notes_container = itemView.findViewById(R.id.notes_container);
        }
    }
}
