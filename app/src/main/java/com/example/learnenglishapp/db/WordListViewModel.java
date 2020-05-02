package com.example.learnenglishapp.db;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordListViewModel extends AndroidViewModel {

    private final LiveData<List<WordModel>> wordLiveData;
    private AppDatabase appDatabase;


    public WordListViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        wordLiveData = appDatabase.wordModelDao().getAllWord();
    }

    public LiveData<List<WordModel>> getWordList(){
        return wordLiveData;
    }

}
