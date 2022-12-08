package com.example.tienda.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.tienda.classes.User;
import com.example.tienda.classes.UserWithDirections;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE userName like :username AND password LIKE :password")
    User authenticate(String username, String password);

    @Query("SELECT * FROM User WHERE id = :id")
    User getUserById(int id);

    @Insert
    void insertUser(User aux);

    @Delete
    void deleteUser(User aux);

    @Update
    void updatetUser(User aux);

    @Transaction
    @Query("SELECT * FROM User WHERE userName LIKE :username")
    UserWithDirections getUserWithDirections(String username);

    @Query("SELECT * FROM User WHERE id = :id")
    User getUserWithBuys(int id);

    @Query("SELECT * FROM User WHERE userName like :username OR email LIKE :email OR phone LIKE :phone")
    User checkRegister(String username, String email, String phone);
}
