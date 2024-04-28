package com.example.moblile4.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moblile4.R;
import com.example.moblile4.data.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder>{
    private ArrayList<ItemModel> data = new ArrayList<>();


    private OnItemClicked onClick;
    public interface OnItemClicked {
        void onItemClick(int position);
    }

    @Override
    public ViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void
    onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getTextfield());
        holder.imageView.setImageResource(data.get(position).getImagefield());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(holder.getAdapterPosition());
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }
    }
    public void updateList(List<ItemModel> list) {
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnClick(OnItemClicked onClick){
        this.onClick = onClick;
    }

}