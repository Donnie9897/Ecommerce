package com.example.tienda.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tienda.classes.User;
import com.example.tienda.classes.UserWithDirections;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE userName like :username AND password LIKE :password")
    User authenticate(String username, String password);

    @Insert
    void insertUser(User aux);

    @Delete
    void deleteUser(User aux);

    @Update
    void updatetUser(User aux);

    @Query("SELECT * FROM User WHERE userName LIKE :username")
    UserWithDirections getUserWithDirections(String username);

    @Query("SELECT * FROM User WHERE id = :id")
    User getUserWithBuys(int id);
}
