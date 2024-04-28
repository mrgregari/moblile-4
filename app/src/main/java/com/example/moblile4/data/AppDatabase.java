package com.example.moblile4.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.moblile4.data.model.MediaEntity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MediaEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MediaDao mediaDao();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static volatile AppDatabase INSTANCE;


    public static AppDatabase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}