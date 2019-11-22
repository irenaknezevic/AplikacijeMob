package com.example.mojaaplikacija;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Student> dataList;

    public MyRecyclerAdapter(List<Student> myDataset) {
        dataList = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentViewHolder myViewHolder = (StudentViewHolder) holder;
        myViewHolder.customTextView.setText(dataList.get(position).sIme);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView customTextView;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            customTextView = itemView.findViewById(R.id.tvHolder);
        }
    }
}
