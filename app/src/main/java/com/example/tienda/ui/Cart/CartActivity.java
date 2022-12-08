package com.example.tienda.ui.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienda.adapters.CartAdapter;
import com.example.tienda.classes.BuyRegister;
import com.example.tienda.classes.Cart;
import com.example.tienda.classes.User;
import com.example.tienda.databinding.ActivityCartBinding;
import com.example.tienda.models.ApplicationViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private Button btn, btn2;
    private RecyclerView recycler;
    private TextView txt_1,txt_2,txt_3;
    ApplicationViewModel applicationViewModel;
    SharedPreferences shared;
    List<Cart> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shared = this.getSharedPreferences("MySharedPref", MODE_PRIVATE);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recycler = binding.recyclerCart;

        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);
        recycler.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        cartList = applicationViewModel.getCartByUserID(shared.getInt("userID",0));
        recycler.setAdapter(new CartAdapter(binding.getRoot().getContext(),cartList, applicationViewModel));

        txt_1 = binding.txt1;
        txt_3 = binding.txt3;
        txt_3.setText(Float.toString(calculateTotal()));
        btn2 = binding.cartGoback;
        btn = binding.checkOut;

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = applicationViewModel.getUserByid(shared.getInt("userID",0));
                if(user.getDirection().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Address! Add one in profile", Toast.LENGTH_LONG);
                    return;
                }
                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String formattedDate = df.format(c);

                BuyRegister aux = new BuyRegister(user.getId(),user.getDirection(),formattedDate,calculateTotal());
                applicationViewModel.registerBuy(aux);
                int id = applicationViewModel.getBuyID();
                updateCart(id);
            }
        });

    }

    public float calculateTotal(){
        float total = 0;
        for(int i = 0; i < cartList.size(); i++){
            total += cartList.get(i).getAmount() * cartList.get(i).getPrice();
        }
        return total;
    }


    public void updateCart(int id){
        for(int i = 0; i < cartList.size(); i++){
            Cart aux = cartList.get(i);
            aux.setBuyID(id);
            applicationViewModel.updateCart(aux);
        }
    }
}