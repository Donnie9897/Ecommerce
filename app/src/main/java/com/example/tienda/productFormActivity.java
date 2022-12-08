package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienda.classes.Product;
import com.example.tienda.databinding.ActivityProductFormBinding;
import com.example.tienda.models.ApplicationViewModel;

import java.util.ArrayList;
import java.util.List;

public class productFormActivity extends AppCompatActivity {

    ActivityProductFormBinding binding;
    ApplicationViewModel applicationViewModel;
    TextView uuid, name, category, description, price;
    List<String> categoryName;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);

        binding = ActivityProductFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categoryName = applicationViewModel.getCategoryName();

        spinner = binding.spinner;
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<String>());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.addAll(categoryName);
        spinnerAdapter.notifyDataSetChanged();

        uuid = binding.idTV;
        name = binding.nameTV;
        description = binding.descriptionTV;
        price = binding.priceTV;
    }
    public void clear(View view){
        uuid.setText("");
        name.setText("");
        description.setText("");
        price.setText("");
    }

    public void register(View view){
        String _uuid = uuid.getText().toString();
        if(_uuid.equalsIgnoreCase("")){
            Toast.makeText(this, "UUID empty!", Toast.LENGTH_LONG).show();
            return;
        }else{
            if(applicationViewModel.getProduct(_uuid) == null){
                String _name = name.getText().toString();
                if(_name.equalsIgnoreCase("")) {
                    Toast.makeText(this, "Name empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                String _description = description.getText().toString();
                if(_description.equalsIgnoreCase("")) {
                    Toast.makeText(this, "description empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                String _price = price.getText().toString();
                if(_price.equalsIgnoreCase("")) {
                    Toast.makeText(this, "Price empty!", Toast.LENGTH_LONG).show();
                    return;
                }else{
                    if(Float.parseFloat(_price) <= 0){
                        Toast.makeText(this, "Price must be greater than cero!", Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                int categoryID = applicationViewModel.checkCategoryName(spinner.getSelectedItem().toString()).getId();
                Product product = new Product(_uuid,_name,_description,Float.parseFloat(_price),categoryID);
                applicationViewModel.addProduct(product);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(this, "Product with same UUID already exist!", Toast.LENGTH_LONG).show();
                return;
            }
        }

    }

    //Establish a way to inflate the spinner with categories

    //Define and initialize binding
    //Create a function onClick to get the data from the form
    //Check if UUID already exist in database
    //If does, show toast, else, create new product and call regProduct
    //Refresh liveData and create new intent to go back to productFragment

    //Check for intent parameter to decide if it's going to create an instance o to update one
    //If its for modify, add a button in case that the want to delete the product
    //Create another onClick for delete

    //Delete function checks in database if product is in order, if it's, send toast explaining
    public void deleteProduct(String id){
            applicationViewModel.deleteProduct(applicationViewModel.getProduct(id));
    }
}