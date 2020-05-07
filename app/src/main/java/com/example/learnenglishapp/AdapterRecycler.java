package com.example.learnenglishapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnenglishapp.db.WordModel;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.RecyclerViewHolder> {

    List<WordModel> wordModels;
    View.OnLongClickListener longClickListener;

    public AdapterRecycler(List<WordModel> wordModels,View.OnLongClickListener longClickListener) {
        this.wordModels = wordModels;
        this.longClickListener = longClickListener;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView ruView;
        private TextView engView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ruView = itemView.findViewById(R.id.russian);
            engView = itemView.findViewById(R.id.english);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_list_item,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if(wordModels.size() != 0) {
            WordModel wordModel = wordModels.get(position);
            holder.ruView.setText(wordModel.getRuWord());
            holder.engView.setText(wordModel.getEngWord());
            holder.itemView.setTag(wordModel);
            holder.itemView.setOnLongClickListener(longClickListener);
        }

    }

    @Override
    public int getItemCount() {
        return wordModels.size();
    }

    public void addItemList(List<WordModel> wordModels){
        this.wordModels = wordModels;
//        this.wordModels.addAll(wordModels);
        notifyDataSetChanged();

    }


}
