package com.example.tienda.database;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import com.example.tienda.classes.Category;
import com.example.tienda.classes.CategoryWithProducts;
import com.example.tienda.classes.Product;

import java.util.List;

public class Repository {
    @SuppressLint("StaticFieldLeak")
    private static Repository repository;

    private ProductDao productDao;
    private CategotyDao categoryDao;

    private Repository(Context context){
        Context appContext = context.getApplicationContext();
        ProductDatabase productDatabase = Room.databaseBuilder(appContext, ProductDatabase.class, "product")
                .allowMainThreadQueries().build();
        CategoryDatabase categoryDatabase = Room.databaseBuilder(appContext, CategoryDatabase.class, "category")
                .allowMainThreadQueries().build();
        productDao = productDatabase.getProductDao();
        categoryDao = categoryDatabase.getCategoryDao();
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

    public Product getProduct(int id){
        return productDao.getProduct(id);
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

    //CategoryFunctions
    public List<Category> getCategories() {return categoryDao.getCategories();};

    public void insertCategory(Category aux) {
        categoryDao.insertCategory(aux);};

    public void deleteCategory(Category aux) {
        categoryDao.deleteCategory(aux);
    };

    public void updateCategoty(Category aux) {categoryDao.updateCategoty(aux);};

    public CategoryWithProducts getCategoryWithProducts(int id) {return categoryDao.getCategoryWithProducts(id);};
}
