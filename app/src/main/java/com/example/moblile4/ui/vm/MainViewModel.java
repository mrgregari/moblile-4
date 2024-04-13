package com.example.moblile4.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moblile4.repository.AppRepository;

public class MainViewModel extends AndroidViewModel {
    private LiveData<String> buttonNavigateToSeries;
    private LiveData<String> buttonNavigateToFilms;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppRepository appRepository = new AppRepository();
        buttonNavigateToSeries = appRepository.getNavigateButtonSeries();
        buttonNavigateToFilms = appRepository.getNavigateButtonFilms();

    }

    public LiveData<String> getButtonNavigateToSeries() {
        return buttonNavigateToSeries;
    }
    public LiveData<String> getButtonNavigateToFilms() {
        return buttonNavigateToFilms;
    }
}
