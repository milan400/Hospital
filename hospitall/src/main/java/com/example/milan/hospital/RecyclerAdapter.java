package com.example.milan.hospital;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Disease> diseases;

    public RecyclerAdapter(List<Disease> diseases)
    {
        this.diseases = diseases;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_symptom,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.SymCheck.setText(diseases.get(position).getSymptoms());
        Log.d("mess", String.valueOf(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return diseases.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView SymCheck;

        public MyViewHolder(View itemView) {
            super(itemView);
            SymCheck = itemView.findViewById(R.id.check_symp);

        }
    }
}
