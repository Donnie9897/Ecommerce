package com.example.tienda.classes;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithDirections {
    @Embedded public User user;
    @Relation(
            parentColumn = "id",
            entityColumn = "userID"
    )
    public List<Direction> directions;
}
