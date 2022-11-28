package com.example.tienda;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class ProductRepository {
    @SuppressLint("StaticFieldLeak")
    private static ProductRepository productRepository;

    private ProductDao productDao;

    private ProductRepository(Context context){
        Context appContext = context.getApplicationContext();
        ProductDatabase database = Room.databaseBuilder(appContext, ProductDatabase.class, "product")
                .allowMainThreadQueries().build();
        productDao = database.getProductDao();
    }

    public static ProductRepository get(Context context){
        if(productRepository == null){
            productRepository = new ProductRepository(context);
        }
        return productRepository;
    }

    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    public Product getProduct(String id){
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
}
