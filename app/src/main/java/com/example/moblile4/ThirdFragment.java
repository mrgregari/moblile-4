package com.example.moblile4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment {
    public ThirdFragment() {super(R.layout.fragment_third); }

    private final static String TAG = "ThirdFragmentLog";
    private static class Item {
        private Drawable image_field;
        private String text_field;
        public Item(String text_field, Drawable image_field) {
            this.text_field = text_field;
            this.image_field = image_field;
        }

        public String getText_field() {
            return text_field;
        }

        public void setText_field(String text_field) {
            this.text_field = text_field;
        }
        public Drawable getImage_field() {return image_field;}
        public void setImage_field(Drawable image_field) {this.image_field = image_field;}
    }

    public static class SecondFragmentRecyclerViewAdapter extends
            RecyclerView.Adapter <SecondFragmentRecyclerViewAdapter.ViewHolder>{
        private final LayoutInflater inflater;
        private final List<Item> items;


        private OnItemClicked onClick;
        public interface OnItemClicked {
            void onItemClick(int position);
        }

        SecondFragmentRecyclerViewAdapter(Context context, List<Item>
                items) {
            this.items = items;
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public ViewHolder
        onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.recycler_item, parent,
                    false);
            return new ViewHolder(view);
        }
        @Override
        public void
        onBindViewHolder(ViewHolder
                                 holder, int position) {
            Item item = items.get(position);
            holder.textView.setText(item.getText_field());
            holder.imageView.setImageDrawable(item.getImage_field());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onItemClick(holder.getAdapterPosition());
                }
            });
        }
        @Override
        public int getItemCount() {
            return items.size();
        }
        public class ViewHolder extends
                RecyclerView.ViewHolder {
            final TextView textView;
            final ImageView imageView;
            ViewHolder(View view){
                super(view);
                textView = view.findViewById(R.id.third_fragment_list_view_item_text_view);
                imageView = view.findViewById(R.id.third_fragment_list_view_item_image_view);
            }
        }

        public void setOnClick(OnItemClicked onClick){
            this.onClick=onClick;
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView itemsList = getActivity().findViewById(R.id.third_fragment_recycler_view);
        List<Item> items = new ArrayList<>();

        for (int i = 1; i <= 250; i++) {
            items.add(new Item("Фильм №" + i, getActivity().getDrawable(R.drawable.film)));
        }

        SecondFragmentRecyclerViewAdapter adapter = new SecondFragmentRecyclerViewAdapter(this.getContext(), items);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(this.getContext().getApplicationContext());
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(adapter);

        adapter.setOnClick(new SecondFragmentRecyclerViewAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {
                View item = itemsList.getLayoutManager().findViewByPosition(position);
                TextView item_text_view = item.findViewById(R.id.third_fragment_list_view_item_text_view);
                String item_str = item_text_view.getText().toString();

                Toast.makeText(getActivity(), "Item '" + item_str + "' pressed!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onListViewItemPressed: " + item_str);
            }
        });
    }
}