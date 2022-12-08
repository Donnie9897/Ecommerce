package com.example.tienda.adapters;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.R;
import com.example.tienda.classes.Cart;
import com.example.tienda.classes.Product;
import com.example.tienda.models.ApplicationViewModel;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    private final Context context;
    private List<Cart> cartList;
    ApplicationViewModel applicationViewModel;
    SharedPreferences shared;
    Cart current;
    Product product;
    public CartAdapter(Context context, List<Cart> products, ApplicationViewModel appVM) {
        this.context = context;
        System.out.println(products.size());
        cartList = products;
        applicationViewModel = appVM;
    }
    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.carrito_item, parent, false);

        shared = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        return new CartAdapter.CartViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        if (cartList != null) {
            current = cartList.get(position);
            product = applicationViewModel.getProduct(current.getProductID());
            holder.name.setText(product.getName());
            holder.price.setText(Float.toString(current.getPrice()));
            holder.amount.setText(Integer.toString(current.getAmount()));
            holder.btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    current.setAmount(current.getAmount() + 1);
                    applicationViewModel.updateCart(current);
                    this.notify();

                }
            });

            holder.btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(current.getAmount() > 0){
                        current.setAmount(current.getAmount() - 1);
                        applicationViewModel.updateCart(current);
                        this.notify();

                    }
                }
            });

            holder.btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    applicationViewModel.deteCart(current);
                    this.notify();
                }
            });
        } else {
            holder.name.setText("No Products");
        }
    }

    @Override
    public int getItemCount() {
        if (cartList != null)
            return cartList.size();
        else return 0;
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, amount;
        Button btnMinus,btnPlus,btnDelete;

        private CartViewHolder(View itemView)  {
            super(itemView);
            name = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.price);
            amount = itemView.findViewById(R.id.amount);
            btnMinus = itemView.findViewById(R.id.minusBTN);
            btnPlus = itemView.findViewById(R.id.plusbtn);
            btnDelete = itemView.findViewById(R.id.deletebtn);

        }
    }
}
