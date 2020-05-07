package com.example.learnenglishapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnenglishapp.addItem.AddWordViewModel;
import com.example.learnenglishapp.db.WordModel;

public class SecondActivity extends AppCompatActivity {

    public EditText ruWord;
    public EditText engWord;
    private AddWordViewModel addWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ruWord = findViewById(R.id.editText);
        engWord = findViewById(R.id.editText2);
        Button saveButton = findViewById(R.id.button);

        addWordViewModel = ViewModelProviders.of(this).get(AddWordViewModel.class);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Editable ruEditText = ruWord.getText();
                final Editable engEditText = engWord.getText();
                if(ruEditText == null || ruEditText.toString().trim().equals("") || engEditText == null || engEditText.toString().trim().equals(""))
                    Toast.makeText(SecondActivity.this,"Missing fields",Toast.LENGTH_LONG).show();
                else {
                    addWordViewModel.addWord(new WordModel(ruWord.getText().toString(),engWord.getText().toString()));
                    finish();
                }
            }
        });

    }
}
