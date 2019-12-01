package com.example.mojaaplikacija;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Object> dataList;
    String title = "Studenti";
    private static final int HEADER = -1;
    private static final int LIST_ITEM = -2;

    public MyRecyclerAdapter(List<Object> myDataset) {
        dataList = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new StudentViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentViewHolder myViewHolder = (StudentViewHolder) holder;
        if(getItemViewType(position) == LIST_ITEM) {
            myViewHolder.tvStudent.setText(((Student) dataList.get(position)).sIme + " " + ((Student) dataList.get(position)).sPrezime + "  ");
            myViewHolder.tvPredmet.setText(((Student) dataList.get(position)).sPredmet);
        }
        else {
            myViewHolder.tvTitle.setText(dataList.get(position).toString());
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(dataList.get(position) instanceof Student) {
            return LIST_ITEM;
        }
        return HEADER;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudent;
        TextView tvPredmet;
        TextView tvTitle;
        public StudentViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            if(viewType  == HEADER) {
                tvTitle = itemView.findViewById(R.id.tvTitle);
            }
            else {
                tvStudent = itemView.findViewById(R.id.tvImePrezime);
                tvPredmet = itemView.findViewById(R.id.tvPredmet);
            }
        }
    }
}
