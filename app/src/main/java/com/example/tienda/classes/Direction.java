package com.example.tienda.classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Direction {
    @PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo(name = "userID")
    private int userID;

    @ColumnInfo(name = "direction")
    private String direction;

    public Direction(int userID, String direction) {
        this.userID = userID;
        this.direction = direction;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
