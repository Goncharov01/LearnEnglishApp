package com.example.learnenglishapp.addItem;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.learnenglishapp.db.AppDatabase;
import com.example.learnenglishapp.db.WordModel;

public class AddWordViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddWordViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }

    public void addWord(final WordModel wordModel){
        new addAsyncTask(appDatabase).execute(wordModel);

    }

    private static class addAsyncTask extends AsyncTask<WordModel, Void, Void>{

        private AppDatabase db;

        public addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final WordModel... wordModels) {
            db.wordModelDao().addWord(wordModels[0]);
            return null;

        }
    }

}
