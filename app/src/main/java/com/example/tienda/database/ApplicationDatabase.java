package com.example.tienda.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tienda.classes.Category;
import com.example.tienda.classes.Product;

@androidx.room.Database(entities = {Product.class, Category.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    public abstract ProductDao getProductDao();
    public abstract CategoryDao getCategoryDao();
}
