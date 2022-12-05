package com.example.tienda.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tienda.classes.Product;

import java.util.List;

@Dao
public interface ProductDao {

    //Access to Products
    @Query("SELECT * FROM Product")
    List<Product> getProducts();

    @Query("SELECT * FROM Product WHERE uuid Like :productID")
    Product getProduct(String productID);

    @Insert
    void insertProduct(Product aux);

    @Delete
    void deleteProduct(Product aux);

    @Update
    void updateProduct(Product aux);

    @Query("SELECT * FROM Product WHERE name LIKE '%' || :name || '%'")
    List<Product> getProductsByName(String name);

}
