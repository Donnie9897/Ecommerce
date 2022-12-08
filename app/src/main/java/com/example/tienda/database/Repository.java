package com.example.tienda.database;

import android.app.Application;

import com.example.tienda.classes.BuyRegister;
import com.example.tienda.classes.Cart;
import com.example.tienda.classes.Category;
import com.example.tienda.classes.CategoryWithProducts;
import com.example.tienda.classes.Product;
import com.example.tienda.classes.User;
import com.example.tienda.classes.UserWithDirections;

import java.util.List;

public class Repository {

    private ProductDao productDao;
    private CategoryDao categoryDao;
    private CartDao cartDao;
    private BuysDao buysDao;
    private UserDao userDao;

    public Repository(Application application){
        ApplicationDatabase database = ApplicationDatabase.getInstance(application);

        productDao = database.getProductDao();
        categoryDao = database.getCategoryDao();
        cartDao = database.getCartDao();
        buysDao = database.getBuysDao();
        userDao = database.getUsersDao();
    }

    //Product Functions
    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    public Product getProduct(String uuid){
        return productDao.getProduct(uuid);
    }

    public void addProduct(Product product){
        ApplicationDatabase.databaseWriteExecutor.execute(() ->
                productDao.insertProduct(product)
        );
    }

    public void updateProduct(Product product){
        ApplicationDatabase.databaseWriteExecutor.execute(() ->
            productDao.updateProduct(product)
        );
    }

    public void deleteProduct(Product product){
        ApplicationDatabase.databaseWriteExecutor.execute(() ->
                productDao.deleteProduct(product)
        );
    }

    public List<Product> getProductsByName(String name) { return productDao.getProductsByName(name);};

    //CategoryFunctions
    public List<Category> getCategories() {return categoryDao.getCategories();};

    public List<String> getCategoryName() {return categoryDao.getCategoryName();}

    public Category checkCategoryName(String name){return categoryDao.chekName(name);}

    public void insertCategory(Category aux) {
        ApplicationDatabase.databaseWriteExecutor.execute(() ->
                categoryDao.insertCategory(aux));
    };

    public void deleteCategory(Category aux) {
        ApplicationDatabase.databaseWriteExecutor.execute(() ->
            categoryDao.deleteCategory(aux));
    };

    public void updateCategoty(Category aux) {
        ApplicationDatabase.databaseWriteExecutor.execute(() ->
                categoryDao.updateCategoty(aux)
        );};

    public CategoryWithProducts getCategoryWithProducts(int id) {return categoryDao.getCategoryWithProducts(id);};

    //Buys Functions
    public void registerBuy(BuyRegister aux){
        ApplicationDatabase.databaseWriteExecutor.execute(() ->
                buysDao.insertBuy(aux));
    }

    public int getID(){return buysDao.getID();};


    //Cart Functions
    public long insertToCart(Cart aux) {
        return cartDao.insertItemToCart(aux);
    }

    public void deleteFromCart(Cart aux) {ApplicationDatabase.databaseWriteExecutor.execute(() -> cartDao.deleteItemInCart(aux));};

    public void updateCartItem(Cart aux){ApplicationDatabase.databaseWriteExecutor.execute(() -> cartDao.updateItemInCart(aux));};

    public List<Cart> getCartByUserID(int id) {return  cartDao.getCartByUserID(id);}

    public Cart checkCart(int id, String productID) {return  cartDao.checkCart(id, productID);}

    //User Functions
    public User authenticate(String username, String password){
        return userDao.authenticate(username, password);
    }

    public void insertUser(User aux) {
        ApplicationDatabase.databaseWriteExecutor.execute(() ->userDao.insertUser(aux));
    }

    public void deleteUser(User aux){
        ApplicationDatabase.databaseWriteExecutor.execute(() ->userDao.deleteUser(aux));
    }

    public void updatetUser(User aux){
        ApplicationDatabase.databaseWriteExecutor.execute(() ->userDao.updatetUser(aux));
    };

    public UserWithDirections getUserWithDirections(String username){
        return userDao.getUserWithDirections(username);
    }

    public User getUserWithBuys(int id){
        return userDao.getUserWithBuys(id);
    }

    public User checkRegister(String user, String email, String phone) {return userDao.checkRegister(user,email,phone);}

    public User getUserById(int id){return userDao.getUserById(id);}
}
