package com.erengulbahar.landmarkbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erengulbahar.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>
{
    ArrayList<LandMark> landMarkArrayList;

    public LandmarkAdapter(ArrayList<LandMark> landMarkArrayList) {
        this.landMarkArrayList = landMarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding= RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.recyclerViewTextView.setText(landMarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //intent.putExtra("landmark",landMarkArrayList.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setSentLanmark(landMarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return landMarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder
    {

        private RecyclerRowBinding binding;


        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
