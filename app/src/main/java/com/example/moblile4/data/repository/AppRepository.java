package com.example.moblile4.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.moblile4.data.AppDatabase;
import com.example.moblile4.data.data_source.AppData;
import com.example.moblile4.data.model.ItemModel;
import com.example.moblile4.data.model.MediaEntity;

import java.util.List;

public class AppRepository {
    private AppDatabase appDatabase;

    public AppRepository(Application application) {
        appDatabase = AppDatabase.getDataBase(application);
    }
    public LiveData<List<MediaEntity>> getAllMedia() {
        return appDatabase.mediaDao().getAllItems();
    }

    public void addMedia(MediaEntity media) {
        AppDatabase.databaseWriterExecutor.execute(() -> {
            appDatabase.mediaDao().insert(media);
        });
    }

    public LiveData<List<ItemModel>> getSeriesData() { return AppData.buildSeriesData(); }
    public LiveData<List<ItemModel>> getFilmsData() { return AppData.buildFilmsData(); }
    public LiveData<String> getNavigateButtonSeries() { return AppData.getNavigateToSeries(); }
    public LiveData<String> getNavigateButtonFilms() { return AppData.getNavigateToFilms(); }
    public LiveData<String> getSeriesTitle() { return AppData.getSeriesTitle(); }
    public LiveData<String> getFilmsTitle() { return AppData.getFilmsTitle(); }
}
