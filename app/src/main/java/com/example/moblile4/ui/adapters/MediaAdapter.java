package com.example.moblile4.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moblile4.R;
import com.example.moblile4.data.model.MediaEntity;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaEntityViewHolder> {
    private List<MediaEntity> media;
    public void setMediaEntities(List<MediaEntity> mediaEntities) {
        media = mediaEntities;
        notifyDataSetChanged();
    }
    @Override
    public MediaEntityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MediaEntityViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MediaEntityViewHolder holder, int position) {
        if (media != null) {
            MediaEntity currentEntity = media.get(position);
            holder.textViewName.setText(currentEntity.getName());
        } else {
            holder.textViewName.setText("No MediaEntity");
        }
    }
    static class MediaEntityViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        public MediaEntityViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
        }
    }
    @Override
    public int getItemCount() {
        return media != null ? media.size() : 0;
    }

}