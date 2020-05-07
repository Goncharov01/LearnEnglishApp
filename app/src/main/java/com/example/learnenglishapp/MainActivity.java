package com.example.learnenglishapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.learnenglishapp.addItem.AddWordViewModel;
import com.example.learnenglishapp.db.WordListViewModel;
import com.example.learnenglishapp.db.WordModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    AdapterRecycler adapterRecycler;
    RecyclerView recyclerView;
    List<WordModel> wordModels = new ArrayList<>();
    FloatingActionButton floatingActionButton;
    AddWordViewModel addWordViewModel;

    private WordListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();


        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                });

        viewModel = ViewModelProviders.of(this).get(WordListViewModel.class);

        viewModel.getWordList().observe(MainActivity.this, new Observer<List<WordModel>>() {
            @Override
            public void onChanged(List<WordModel> wordModels) {
                adapterRecycler.addItemList(wordModels);
            }
        });

    }

    public void initRecyclerView() {
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterRecycler = new AdapterRecycler(new ArrayList<WordModel>(),this);
        recyclerView.setAdapter(adapterRecycler);
    }


    @Override
    public boolean onLongClick(View v) {
        WordModel wordModel = (WordModel) v.getTag();
        viewModel.deleteItem(wordModel);
        return true;
    }
}
