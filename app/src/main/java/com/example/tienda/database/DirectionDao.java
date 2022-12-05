package com.example.tienda.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.tienda.classes.Direction;

@Dao
public interface DirectionDao {
    @Insert
    void insertDirection(Direction aux);

    @Delete
    void deleteDirection(Direction aux);

    @Update
    void updateDirection(Direction aux);
}
