package com.example.tienda.classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey
    @NonNull
    private String uuid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "price")
    private float price;

    @ColumnInfo(name = "categoryId")
    private int categoryId;

    public Product(String uuid, String name, String description, float price, int categoryId) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid =  uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCategoryId(){return categoryId;}

    public void setCategoryId(int categoryId){this.categoryId = categoryId;}
}