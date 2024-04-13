package com.example.moblile4.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.moblile4.R;
import com.example.moblile4.ui.vm.MainViewModel;
import com.example.moblile4.ui.vm.RecyclerViewModel;

public class MainFragment extends Fragment {

    private MainViewModel viewModel;
    private Button buttonCheckSeries;
    private Button buttonCheckFilms;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonCheckSeries = getActivity().findViewById(R.id.buttonSeries);
        buttonCheckFilms = getActivity().findViewById(R.id.buttonFilms);
        viewModel.getButtonNavigateToSeries().observe(getViewLifecycleOwner(), text ->
                buttonCheckSeries.setText(text));
        viewModel.getButtonNavigateToFilms().observe(getViewLifecycleOwner(), text ->
                buttonCheckFilms.setText(text));
        buttonCheckSeries.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "series");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
        buttonCheckFilms.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "films");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
    }
}