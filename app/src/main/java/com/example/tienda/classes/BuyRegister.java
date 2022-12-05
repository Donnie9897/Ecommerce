package com.example.tienda.classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BuyRegister {
    @PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo(name = "userID")
    private int userID;

    @ColumnInfo(name = "directionId")
    private int directionId;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "total")
    private float total;

    public BuyRegister(int userID, int directionId, String date, float total) {
        this.userID = userID;
        this.directionId = directionId;
        this.date = date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
