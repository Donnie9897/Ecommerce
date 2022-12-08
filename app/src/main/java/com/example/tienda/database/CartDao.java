package com.example.tienda.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tienda.classes.Cart;

import java.util.List;

@Dao
public interface CartDao {
    @Insert
    long insertItemToCart(Cart aux);

    @Delete
    void deleteItemInCart(Cart aux);

    @Update
    void updateItemInCart(Cart aux);

    @Query("SELECT * FROM Cart WHERE userID = :userID and buyID >= 0")
    List<Cart> getCartByUserID(int userID);

    @Query("SELECT * FROM Cart WHERE userID = :userID AND productID like :productID")
    Cart checkCart(int userID, String productID);
}
