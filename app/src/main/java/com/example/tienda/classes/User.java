package com.example.tienda.classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "direction")
    private String direction;

    @Ignore
    private List<cartProduct> shoppingCart;

    public User(String userName, String password, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.shoppingCart = new ArrayList<cartProduct>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<cartProduct> getShoppingCart() {
        return shoppingCart;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setShoppingCart(List<cartProduct> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addProductToCart(Product product, int cant){
        cartProduct aux = new cartProduct(product.getUuid(), product.getPrice(), cant);
        shoppingCart.add(aux);
    }

    public float getCartTotal(){
        float total = 0;
        for(int i = 0; i < shoppingCart.size(); i++){
            total += shoppingCart.get(i).getAmount() * shoppingCart.get(i).getPrice();
        }

        return total;
    }

    public void clearCart(){
        shoppingCart = new ArrayList<cartProduct>();
    }

    class cartProduct {
        private String productID;
        private float price;
        private int amount;

        public cartProduct(String productID, float price, int amount) {
            this.productID = productID;
            this.amount = amount;
            this.price = price;
        }

        public String getProductID() {
            return productID;
        }

        public void setProductID(String productID) {
            this.productID = productID;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }
    }
}
