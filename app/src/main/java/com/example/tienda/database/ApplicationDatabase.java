package com.example.tienda.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tienda.classes.BuyRegister;
import com.example.tienda.classes.Category;
import com.example.tienda.classes.Direction;
import com.example.tienda.classes.Product;
import com.example.tienda.classes.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Product.class, Category.class, Direction.class, User.class, BuyRegister.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {

    private static String NAME = "ECommerce";
    private static volatile ApplicationDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ApplicationDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (ApplicationDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }

        return INSTANCE;
    }
    public abstract ProductDao getProductDao();
    public abstract CategoryDao getCategoryDao();
    public abstract DirectionDao getDirectionDao();
    public abstract BuysDao getBuysDao();
    public abstract UserDao getUsersDao();

}
