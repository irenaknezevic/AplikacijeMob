package com.example.mojaaplikacija;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> dataList;

    public MyRecyclerAdapter(List<String> myDataset) {
        dataList = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.customTextView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView customTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            customTextView = itemView.findViewById(R.id.tvHolder);
        }
    }
}
