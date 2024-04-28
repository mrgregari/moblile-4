package com.example.moblile4.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moblile4.databinding.FragmentMediaBinding;
import com.example.moblile4.ui.adapters.MediaAdapter;
import com.example.moblile4.ui.vm.MainViewModel;


public class MediaFragment extends Fragment {
    FragmentMediaBinding binding;
    private MainViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMediaBinding.inflate(inflater);

        binding.listMedia.setLayoutManager(new LinearLayoutManager(requireContext()));
        MediaAdapter adapter = new MediaAdapter();
        binding.listMedia.setAdapter(adapter);

        binding.buttonAdd.setOnClickListener(v ->
                viewModel.addPerfumery(binding.editTextMediaName.getText().toString())
        );

        viewModel.getAllMedia().observe(getViewLifecycleOwner(), perfumery ->
                adapter.setMediaEntities(perfumery));
        return binding.getRoot();
    }
}