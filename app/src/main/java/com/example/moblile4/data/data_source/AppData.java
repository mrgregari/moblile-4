package com.example.moblile4.data.data_source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moblile4.R;
import com.example.moblile4.data.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    public static LiveData<List<ItemModel>> buildSeriesData() {
        MutableLiveData<List<ItemModel>> seriesData = new MutableLiveData<>();
        ArrayList<ItemModel> series = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            series.add(new ItemModel("Series № " + (i + 1), R.drawable.series));
        }
        seriesData.setValue(series);
        return seriesData;
    }

    public static LiveData<List<ItemModel>> buildFilmsData() {
        MutableLiveData<List<ItemModel>> filmsData = new MutableLiveData<>();
        ArrayList<ItemModel> films = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            films.add(new ItemModel("Film № " + (i + 1), R.drawable.film));
        }
        filmsData.setValue(films);
        return filmsData;
    }

    public static LiveData<String> getNavigateToSeries() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к сериалам");
        return data;
    }

    public static LiveData<String> getNavigateToFilms() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к фильмам");
        return data;
    }

    public static LiveData<String> getSeriesTitle() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Сериалы");
        return data;
    }

    public static LiveData<String> getFilmsTitle() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Фильмы");
        return data;
    }
}
