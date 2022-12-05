package com.example.tienda.classes;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;


public class CategoryWithProducts {
    @Embedded public Category category;
    @Relation(
            parentColumn = "id",
            entityColumn = "categoryId"
    )
    public List<Product> products;
}
