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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentViewHolder myViewHolder = (StudentViewHolder) holder;
        myViewHolder.tvStudent.setText(dataList.get(position).sIme + " " + dataList.get(position).sPrezime + "  ");
        myViewHolder.tvPredmet.setText(dataList.get(position).sPredmet);
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
        TextView tvStudent;
        TextView tvPredmet;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudent = itemView.findViewById(R.id.tvImePrezime);
            tvPredmet = itemView.findViewById(R.id.tvPredmet);
        }
    }
}
