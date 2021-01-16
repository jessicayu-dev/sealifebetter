package com.example.myapplication;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MoodRepository {
    private MoodDao moodDao;
    private LiveData<List<Mood>> allMoods;

    public MoodRepository(Application application) {
        MoodDatabase database = MoodDatabase.getInstance(application);
        allMoods = moodDao.getAllMoods();
    }

    public void insert(Mood mood) {
        new InsertMoodAsyncTask(moodDao).execute(mood);
    }

    public void update(Mood mood) {
        new UpdateMoodAsyncTask(moodDao).execute(mood);
    }

    public void delete(Mood mood) {
        new DeleteMoodAsyncTask(moodDao).execute(mood);
    }

    public LiveData<List<Mood>> getAllMoods() {
        return allMoods;
    }

    private static class InsertMoodAsyncTask extends AsyncTask<Mood, Void, Void> {
        private MoodDao moodDao;

        private InsertMoodAsyncTask(MoodDao moodDao) {
            this.moodDao = moodDao;
        }

        @Override
        protected Void doInBackground(Mood... moods) {
            moodDao.insert(moods[0]);
            return null;
        }
    }

    private static class UpdateMoodAsyncTask extends AsyncTask<Mood, Void, Void> {
        private MoodDao moodDao;

        private UpdateMoodAsyncTask(MoodDao moodDao) {
            this.moodDao = moodDao;
        }

        @Override
        protected Void doInBackground(Mood... moods) {
            moodDao.update(moods[0]);
            return null;
        }
    }

    private static class DeleteMoodAsyncTask extends AsyncTask<Mood, Void, Void> {
        private MoodDao moodDao;

        private DeleteMoodAsyncTask(MoodDao moodDao) {
            this.moodDao = moodDao;
        }

        @Override
        protected Void doInBackground(Mood... moods) {
            moodDao.delete(moods[0]);
            return null;
        }
    }
}
