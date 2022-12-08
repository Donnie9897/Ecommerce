package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienda.classes.Category;
import com.example.tienda.databinding.ActivityCategoryFormBinding;
import com.example.tienda.models.ApplicationViewModel;

public class CategoryFormActivity extends AppCompatActivity {

    ActivityCategoryFormBinding binding;
    TextView categoryName;
    ApplicationViewModel applicationViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        categoryName = binding.name;
        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);

    }

    public void registerCategory(View view){
        String name = categoryName.getText().toString();
        if(name.equalsIgnoreCase("")){
            Toast.makeText(this, "Empty category name", Toast.LENGTH_LONG).show();
            return;
        }else{
            if(applicationViewModel.checkCategoryName(name)== null){
                Category aux = new Category(name, "");
                applicationViewModel.insertCategory(aux);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Category already exists!", Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

    public void clear(View view){
        categoryName.setText("");
    }
    //Define and initialize binding
    //Create a function onClick to get the data from the form
    //Check if category name already exist in database
    //If does, show toast, else, create new product and call addCategory
    //Refresh liveData and create new intent to go back to productFragment

    //Check for intent parameter to decide if it's going to create an instance o to update one
    //If its for modify, add a button in case that the want to delete the category
    //Create another onClick for delete

    //Delete function checks in database if category has products, if that's the case, send Toast
}