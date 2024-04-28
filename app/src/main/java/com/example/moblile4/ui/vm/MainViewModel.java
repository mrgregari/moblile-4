package com.example.moblile4.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moblile4.data.model.MediaEntity;
import com.example.moblile4.data.repository.AppRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    AppRepository appRepository;

    public LiveData<List<MediaEntity>> getAllMedia() {
        return appRepository.getAllMedia();
    }
    public void addPerfumery(String name) {
        appRepository.addMedia(new MediaEntity(name));
    }
    public MainViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);

    }
    public LiveData<String> getButtonNavigateToSeries() {
        return appRepository.getNavigateButtonSeries();
    }
    public LiveData<String> getButtonNavigateToFilms() {
        return appRepository.getNavigateButtonFilms();
    }
}
