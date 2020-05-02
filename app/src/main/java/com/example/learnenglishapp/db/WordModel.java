package com.example.learnenglishapp.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WordModel {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String ruWord;
    private String engWord;

    public WordModel(String ruWord, String engWord) {
        this.ruWord = ruWord;
        this.engWord = engWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuWord() {
        return ruWord;
    }

    public void setRuWord(String ruWord) {
        this.ruWord = ruWord;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }
}
