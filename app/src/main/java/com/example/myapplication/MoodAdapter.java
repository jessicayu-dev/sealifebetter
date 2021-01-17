package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.MoodHolder> {


    @NonNull
    @Override
    public MoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MoodHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MoodHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView entry;
        private TextView log;

        public MoodHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.mood_id);
            entry = itemView.findViewById(R.id.mood_entry);
            log = itemView.findViewById(R.id.mood_log);
        }
    }
}
