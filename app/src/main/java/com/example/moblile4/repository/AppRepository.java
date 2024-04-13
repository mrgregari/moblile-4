package com.example.moblile4.repository;

import androidx.lifecycle.LiveData;

import com.example.moblile4.data_source.AppData;
import com.example.moblile4.model.ItemModel;

import java.util.List;

public class AppRepository {

    public LiveData<List<ItemModel>> getSeriesData() { return AppData.buildSeriesData(); }
    public LiveData<List<ItemModel>> getFilmsData() { return AppData.buildFilmsData(); }
    public LiveData<String> getNavigateButtonSeries() { return AppData.getNavigateToSeries(); }
    public LiveData<String> getNavigateButtonFilms() { return AppData.getNavigateToFilms(); }
    public LiveData<String> getSeriesTitle() { return AppData.getSeriesTitle(); }
    public LiveData<String> getFilmsTitle() { return AppData.getFilmsTitle(); }
}
