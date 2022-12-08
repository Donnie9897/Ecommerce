package com.example.tienda.ui.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tienda.R;
import com.example.tienda.databinding.ActivityCartBinding;
import com.example.tienda.models.ApplicationViewModel;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private Button btn;
    private RecyclerView recycler;
    private TextView txt_1,txt_2,txt_3;
    ApplicationViewModel applicationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);

        txt_1 = binding.txt1;
        txt_2 = binding.txt2;
        txt_3 = binding.txt3;
        recycler = binding.recyclerCart;
    }

    //Create a function that gets all products from cart and load it inside a List<>
    //If user click buy, take list and add it to the database
    //Delete all the old items from cart

    //Create a new notification to the database
}