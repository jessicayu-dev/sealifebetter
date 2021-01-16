package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.MoodHolder> {



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
