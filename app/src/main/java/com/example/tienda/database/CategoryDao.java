package com.example.tienda.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.tienda.classes.Category;
import com.example.tienda.classes.CategoryWithProducts;

import java.util.List;

@Dao
public interface CategoryDao {

    //Access to Categories
    @Query("SELECT * FROM Category")
    List<Category> getCategories();

    @Insert
    void insertCategory(Category aux);

    @Delete
    void deleteCategory(Category aux);

    @Update
    void updateCategoty(Category aux);

    //Acces to Categories with Products
    @Transaction
    @Query("SELECT * FROM Category WHERE id = :id")
    CategoryWithProducts getCategoryWithProducts(int id);
}
