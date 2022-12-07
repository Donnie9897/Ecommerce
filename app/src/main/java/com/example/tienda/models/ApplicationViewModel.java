package com.example.tienda.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tienda.classes.BuyRegister;
import com.example.tienda.classes.Category;
import com.example.tienda.classes.CategoryWithProducts;
import com.example.tienda.classes.Direction;
import com.example.tienda.classes.Product;
import com.example.tienda.classes.User;
import com.example.tienda.classes.UserWithDirections;
import com.example.tienda.database.Repository;
import com.example.tienda.database.ApplicationDatabase;

import java.util.List;

public class ApplicationViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Category>> allCategories;

    public ApplicationViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public List<Product> getProducts(){
        return repository.getProducts();
    }

    public Product getProduct(String uuid){
        return repository.getProduct(uuid);
    }

    public void addProduct(Product product){
        repository.addProduct(product);
        ;
    }

    public void updateProduct(Product product){
        repository.updateProduct(product);
    }

    public void deleteProduct(Product product){
        repository.deleteProduct(product);
    }

    public List<Product> getProductsByName(String name) { return repository.getProductsByName(name);};

    //CategoryFunctions
    public List<Category> getCategories() {return repository.getCategories();};

    public void insertCategory(Category aux) {
                repository.insertCategory(aux);
    }

    public void deleteCategory(Category aux) {
        repository.deleteCategory(aux);
    }

    public void updateCategoty(Category aux) {
                repository.updateCategoty(aux);
    }


    public CategoryWithProducts getCategoryWithProducts(int id) {return repository.getCategoryWithProducts(id);};

    //Buys Functions
    public void registerBuy(BuyRegister aux){
                repository.registerBuy(aux);
    }

    //Direction Functions
    public void insertDirection(Direction aux) {
        repository.insertDirection(aux);}

    public void deleteDirection(Direction aux) {
        repository.deleteDirection(aux);
    }

    public void updateDirection(Direction aux){
        repository.updateDirection(aux);
    }

    //User Functions
    public User authenticate(String username, String password){
        return repository.authenticate(username, password);
    }

    public void insertUser(User aux) {
        repository.insertUser(aux);
    }

    public void deleteUser(User aux){
        repository.deleteUser(aux);
    }

    public void updatetUser(User aux){
        repository.updatetUser(aux);
    };

    public UserWithDirections getUserWithDirections(String username){
        return repository.getUserWithDirections(username);
    }

    public User getUserWithBuys(int id){
        return repository.getUserWithBuys(id);
    }

    public User checkRegister(String user, String email, String phone) {return repository.checkRegister(user,email,phone);}
}
