package com.example.tienda.database;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.Update;

import com.example.tienda.classes.BuyRegister;
import com.example.tienda.classes.Category;
import com.example.tienda.classes.CategoryWithProducts;
import com.example.tienda.classes.Direction;
import com.example.tienda.classes.Product;
import com.example.tienda.classes.User;
import com.example.tienda.classes.UserWithDirections;

import java.util.List;

public class Repository {
    @SuppressLint("StaticFieldLeak")
    private static Repository repository;

    private ProductDao productDao;
    private CategoryDao categoryDao;
    private DirectionDao directionDao;
    private BuysDao buysDao;
    private UserDao userDao;

    private Repository(Context context){
        Context appContext = context.getApplicationContext();
        ApplicationDatabase database = Room.databaseBuilder(appContext, ApplicationDatabase.class, "ECommerce")
                .allowMainThreadQueries().build();

        productDao = database.getProductDao();
        categoryDao = database.getCategoryDao();
        directionDao = database.getDirectionDao();
        buysDao = database.getBuysDao();
        userDao = database.getUsersDao();
    }

    public static Repository get(Context context){
        if(repository == null){
            repository = new Repository(context);
        }
        return repository;
    }
    //Product Functions
    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    public Product getProduct(String uuid){
        return productDao.getProduct(uuid);
    }

    public void addProduct(Product product){
        productDao.insertProduct(product);
    }

    public void updateProduct(Product product){
        productDao.updateProduct(product);
    }

    public void deleteProduct(Product product){
        productDao.deleteProduct(product);
    }

    public List<Product> getProductsByName(String name) { return productDao.getProductsByName(name);};

    //CategoryFunctions
    public List<Category> getCategories() {return categoryDao.getCategories();};

    public void insertCategory(Category aux) {
        categoryDao.insertCategory(aux);};

    public void deleteCategory(Category aux) {
        categoryDao.deleteCategory(aux);
    };

    public void updateCategoty(Category aux) {categoryDao.updateCategoty(aux);};

    public CategoryWithProducts getCategoryWithProducts(int id) {return categoryDao.getCategoryWithProducts(id);};

    //Buys Functions
    public void registerBuy(BuyRegister aux){
        buysDao.insertBuy(aux);
    }

    //Direction Functions
    public void insertDirection(Direction aux) {directionDao.insertDirection(aux);};

    public void deleteDirection(Direction aux) {directionDao.deleteDirection(aux);};

    public void updateDirection(Direction aux){directionDao.updateDirection(aux);};

    //User Functions
    public User authenticate(String username, String password){
        return userDao.authenticate(username, password);
    }

    public void insertUser(User aux) {
        userDao.insertUser(aux);
    }

    public void deleteUser(User aux){
        userDao.deleteUser(aux);
    }

    public void updatetUser(User aux){
        userDao.updatetUser(aux);
    };

    public UserWithDirections getUserWithDirections(String username){
        return userDao.getUserWithDirections(username);
    }

    public User getUserWithBuys(int id){
        return userDao.getUserWithBuys(id);
    }
}
