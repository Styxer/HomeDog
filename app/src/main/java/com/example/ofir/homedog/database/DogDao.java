package com.example.ofir.homedog.Database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Dog dog);

    @Update
    void update(Dog dog);

    @Delete
    void delete(Dog dog);

    @Query("DELETE FROM dog_table")
    void deleteAllNotes();

    @Query("SELECT * FROM DOG_TABLE ORDER BY id DESC")
    LiveData<List<Dog>> getAllDogsById();
}
