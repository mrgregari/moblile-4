package com.example.moblile4.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.moblile4.data.model.MediaEntity;

import java.util.List;

@Dao
public interface MediaDao {
    @Query("SELECT * FROM mediaentity")
    LiveData<List<MediaEntity>> getAllItems();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MediaEntity entity);
}
