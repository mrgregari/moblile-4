package com.example.moblile4.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moblile4.data.model.ItemModel;
import com.example.moblile4.data.repository.AppRepository;

import java.util.List;

public class RecyclerViewModel extends AndroidViewModel {
    private LiveData<List<ItemModel>> seriesData;
    private LiveData<List<ItemModel>> filmsData;
    private LiveData<String> seriesTitle;
    private LiveData<String> filmsTitle;
    public RecyclerViewModel(@NonNull Application application) {
        super(application);
        AppRepository appRepository = new AppRepository(application);
        seriesData = appRepository.getSeriesData();
        filmsData = appRepository.getFilmsData();
        seriesTitle = appRepository.getSeriesTitle();
        filmsTitle = appRepository.getFilmsTitle();
    }

    public LiveData<List<ItemModel>> getSeriesData() {
        return seriesData;
    }

    public LiveData<String> getSeriesTitle() {
        return seriesTitle;
    }

    public LiveData<List<ItemModel>> getFilmsData() {
        return filmsData;
    }

    public LiveData<String> getFilmsTitle() {
        return filmsTitle;
    }
}
