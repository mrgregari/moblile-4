package com.example.moblile4.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moblile4.R;
import com.example.moblile4.ui.adapters.RecyclerViewAdapter;
import com.example.moblile4.ui.vm.RecyclerViewModel;

public class RecyclerFragment extends Fragment {
    private RecyclerViewModel viewModel;
    private RecyclerView recyclerView;
    private TextView title;

    public RecyclerFragment() {super(R.layout.fragment_recycler); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(RecyclerViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        title = getActivity().findViewById(R.id.title);
        String data = getArguments().getString("key");
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        if (data == "series") {
            viewModel.getSeriesData().observe(getViewLifecycleOwner(), list ->
                    adapter.updateList(list));
            viewModel.getSeriesTitle().observe(getViewLifecycleOwner(), text->
                    title.setText(text));
        } else if (data == "films") {
            viewModel.getFilmsData().observe(getViewLifecycleOwner(), list ->
                    adapter.updateList(list));
            viewModel.getFilmsTitle().observe(getViewLifecycleOwner(), text->
                    title.setText(text));
        } 


/*
        RecyclerView itemsList = getActivity().findViewById(R.id.recyclerView);
        List<ItemModel> items = new ArrayList<>();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this.getContext(), items);
        LinearLayoutManager layoutManager = new
                LinearLayoutManager(this.getContext().getApplicationContext());
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(adapter);

        adapter.setOnClick(new RecyclerViewAdapter.OnItemClicked() {
            @Override
            public void onItemClick(int position) {
                View item = itemsList.getLayoutManager().findViewByPosition(position);
                TextView itemViewById = item.findViewById(R.id.textView);
                String itemStr = itemViewById.getText().toString();
                Toast.makeText(getActivity(), "Item '" + itemStr + "' pressed!", Toast.LENGTH_SHORT).show();
            }
        });

 */
    }
}