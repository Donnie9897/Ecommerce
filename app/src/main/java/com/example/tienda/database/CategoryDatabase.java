package com.example.tienda.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tienda.classes.Category;

@Database(entities = {Category.class}, version = 1)
public abstract class CategoryDatabase extends RoomDatabase {
    public abstract CategotyDao getCategoryDao();

}
