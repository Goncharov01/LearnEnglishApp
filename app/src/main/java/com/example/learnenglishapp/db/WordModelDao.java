package com.example.learnenglishapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface WordModelDao {

    @Query("select * from WordModel")
    LiveData<List<WordModel>> getAllWord();

    @Query("select * from WordModel where id = :id")
    WordModel getWordId(String id);

    @Insert (onConflict = REPLACE)
    void addWord (WordModel wordModel);

    @Delete
    void deleteWord(WordModel wordModel);


}
