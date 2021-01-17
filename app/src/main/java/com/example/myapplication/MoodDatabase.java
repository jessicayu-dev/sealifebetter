package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Mood.class}, version = 1)
public abstract class MoodDatabase extends RoomDatabase {

    private static MoodDatabase instance;

    public abstract MoodDao moodDao();

    public static synchronized MoodDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MoodDatabase.class, "mood_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private MoodDao moodDao;

        private PopulateDBAsyncTask(MoodDatabase db) {
            moodDao = db.moodDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            moodDao.insert(new Mood(5, "Doing good.", "I went to the store and bought cookies."));
            moodDao.insert(new Mood(1, "Doing bad.", "I didn't go anywhere today."));
            return null;
        }
    }
}
