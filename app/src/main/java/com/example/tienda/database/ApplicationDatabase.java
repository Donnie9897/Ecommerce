package com.example.tienda.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.tienda.classes.BuyRegister;
import com.example.tienda.classes.Category;
import com.example.tienda.classes.Direction;
import com.example.tienda.classes.Product;
import com.example.tienda.classes.User;

@androidx.room.Database(entities = {Product.class, Category.class, Direction.class, User.class, BuyRegister.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    public abstract ProductDao getProductDao();
    public abstract CategoryDao getCategoryDao();
    public abstract DirectionDao getDirectionDao();
    public abstract BuysDao getBuysDao();
    public abstract UserDao getUsersDao();

}
