package com.example.tienda.classes;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithBuys {
    @Embedded User user;
    @Relation(
            parentColumn = "id",
            entityColumn = "userID"
    )
    public List<BuyRegister> Buys;
}
