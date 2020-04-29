package com.example.learnenglishapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.RecyclerViewHolder> {

    Context context;
    List<DataModel> dataModels = new ArrayList<>();

    public AdapterRecycler(Context context, List<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
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
        View view = LayoutInflater.from(context)
                .inflate(R.layout.task_list_item,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if(dataModels.size() != 0) {
            DataModel dataModel = dataModels.get(position);
            holder.ruView.setText(dataModel.getRu());
            holder.engView.setText(dataModel.getRu());
        }

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }


}
