package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienda.classes.User;
import com.example.tienda.database.Repository;
import com.example.tienda.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private TextView usernameTV, emailTV, phoneTV, passwordTV, confirmationTV;
    private Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repo = Repository.get(getApplicationContext());

        usernameTV = binding.username;
        emailTV = binding.email;
        phoneTV = binding.phone;
        passwordTV = binding.password;
        confirmationTV = binding.passwordConfirmation;
    }

    public void register(View view){
        String username = usernameTV.getText().toString();
        String email = emailTV.getText().toString();
        String phone = phoneTV.getText().toString();
        String password = passwordTV.getText().toString();
        String passwordConfirmation  = confirmationTV.getText().toString();

        if (username.equalsIgnoreCase("")){
            Toast.makeText(this, "Empty Username", Toast.LENGTH_LONG).show();
            return;
        }
        if (email.equalsIgnoreCase("")){
            Toast.makeText(this, "Empty Email", Toast.LENGTH_LONG).show();
            return;
        }
        if (phone.equalsIgnoreCase("")){
            Toast.makeText(this, "Empty Contact Number", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equalsIgnoreCase("")){
            Toast.makeText(this, "Empty Password", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password.equalsIgnoreCase(passwordConfirmation)){
            Toast.makeText(this, "Password must match with the confirmation", Toast.LENGTH_LONG).show();
            return;
        }

        User user = Repository.get(getApplicationContext()).checkRegister(username, email, phone);
        if (user != null){
            Toast.makeText(this, "Some of the information provided has already been recorded", Toast.LENGTH_LONG).show();
            return;
        }else{
            //Save on database and go back to login
            repo.insertUser(new User(username, password,email, phone));
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

}