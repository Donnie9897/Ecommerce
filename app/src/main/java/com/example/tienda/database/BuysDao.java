package com.example.tienda.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tienda.classes.BuyRegister;
import com.example.tienda.classes.User;

@Dao
public interface BuysDao {

    @Insert
    void insertBuy(BuyRegister aux);

}
