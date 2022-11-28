package com.example.tienda;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM Product")
    List<Product> getProducts();

    @Query("SELECT * FROM Product WHERE Id Like :productID")
    Product getProduct(String productID);

    @Insert
    void insertProduct(Product aux);

    @Delete
    void deleteProduct(Product aux);

    @Update
    void updateProduct(Product aux);
}
