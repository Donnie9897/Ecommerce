package com.example.tienda.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tienda.classes.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao getProductDao();
}
