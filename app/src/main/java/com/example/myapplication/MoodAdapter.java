package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.MoodHolder> {

    List<Mood> moods = new ArrayList<>();

    @NonNull
    @Override
    public MoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mood_card, parent, false);
        return new MoodHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodHolder holder, int position) {
        Mood currentMood = moods.get(position);
        holder.id.setText("Mood: " + currentMood.getMoodValue());
        holder.entry.setText("Entry: " + currentMood.getEntry());
        holder.log.setText("Log: " + currentMood.getLog());
    }

    @Override
    public int getItemCount() {
        return moods.size();
    }

    public void setMoods(List<Mood> moods) {
        this.moods = moods;
        notifyDataSetChanged();
    }

    class MoodHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView entry;
        private TextView log;

        public MoodHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.mood_value);
            entry = itemView.findViewById(R.id.mood_entry);
            log = itemView.findViewById(R.id.mood_log);
        }
    }
}
