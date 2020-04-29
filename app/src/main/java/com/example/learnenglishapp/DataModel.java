package com.example.learnenglishapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DataModel {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String ru;
    private String eng;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }
}
