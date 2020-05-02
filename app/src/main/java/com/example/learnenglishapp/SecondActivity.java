package com.example.learnenglishapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnenglishapp.addItem.AddWordViewModel;
import com.example.learnenglishapp.db.WordModel;

public class SecondActivity extends AppCompatActivity {

    public EditText ruWord;
    public EditText engWord;
    Button saveButton;
    private AddWordViewModel addWordViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ruWord = findViewById(R.id.editText);
        engWord = findViewById(R.id.editText2);
        saveButton = findViewById(R.id.button);

        addWordViewModel = ViewModelProviders.of(this).get(AddWordViewModel.class);




        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(ruWord.getText() == null || engWord.getText() ==null)
                            Toast.makeText(SecondActivity.this,"Missing field", Toast.LENGTH_SHORT).show();
                        else {
                           addWordViewModel.addWord(new WordModel(ruWord.getText().toString(),engWord.getText().toString()));
                           finish();
                        }
                    }
                });


    }
}
