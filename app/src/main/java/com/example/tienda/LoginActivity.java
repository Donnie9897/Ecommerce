package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienda.classes.Category;
import com.example.tienda.classes.Product;
import com.example.tienda.classes.User;
import com.example.tienda.database.Repository;
import com.example.tienda.databinding.ActivityLoginBinding;
import com.example.tienda.models.ApplicationViewModel;
import com.example.tienda.ui.home.HomeViewModel;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private TextView usernameTV, passwordTV;
    ApplicationViewModel applicationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        usernameTV = binding.username;
        passwordTV = binding.password;
        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);

        SharedPreferences shared = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        if (shared.getAll().containsKey("userID")){
            goLogin();
        }

    }

    //Login Btn functionality
    public void logIn(View view){
        String username = usernameTV.getText().toString();
        String password = passwordTV.getText().toString();

        if (username.equalsIgnoreCase("")){
            Toast.makeText(this, "Empty Username", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equalsIgnoreCase("")){
            Toast.makeText(this, "Empty password", Toast.LENGTH_LONG).show();
            return;
        }

        User user = applicationViewModel.authenticate(username, password);
        System.out.println("We found " + user);
        if(user == null){
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show();
            return;
        }else {
            //Save userID using shared preference to be access from anywhere in the app
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putInt("userID", user.getId());
            myEdit.putString("userName", user.getUserName());
            myEdit.apply();
            applicationViewModel.insertCategory(new Category("Categoria Prueba","Una categoria de prueba"));

            goLogin();
        }
    }


    public void goLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //Register Btn functionality
    public void loadRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}