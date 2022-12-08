package com.example.tienda.adapters;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.R;
import com.example.tienda.classes.Cart;
import com.example.tienda.classes.Product;
import com.example.tienda.models.ApplicationViewModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private final Context context;
    private List<Product> productList;
    ApplicationViewModel applicationViewModel;
    SharedPreferences shared;
    Product current;
    public ProductAdapter(Context context, List<Product> products, ApplicationViewModel appVM) {
        this.context = context;
        productList = products;
        applicationViewModel = appVM;

    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        shared = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        return new ProductViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (productList != null) {
            System.out.println(productList.get(0).getName());

            current = productList.get(position);
            holder.name.setText(current.getName());
            holder.price.setText("Price: " + Float.toString(current.getPrice()));
            holder.description.setText(current.getDescription());

            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int userID = shared.getInt("userID",0);
                    Cart cart = applicationViewModel.checkCart(userID,current.getUuid());
                    if( cart == null){
                        cart = new Cart(userID,current.getUuid(),1,current.getPrice());
                        System.out.println(applicationViewModel.insertCart(cart));
                    }else{
                        cart.setAmount(cart.getAmount() + 1);
                        applicationViewModel.updateCart(cart);
                        System.out.println(applicationViewModel.getCartByUserID(userID).size());

                    }

                }
            });
        } else {
            holder.name.setText("No Products");
        }
    }

    @Override
    public int getItemCount() {
        if (productList != null)
            return productList.size();
        else return 0;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView name, description, price;
        Button btn;
        private ProductViewHolder(View itemView)  {
            super(itemView);
            name = itemView.findViewById(R.id.categoria_desc);
            price = itemView.findViewById(R.id.price_add);
            description = itemView.findViewById(R.id.description);
            btn = itemView.findViewById(R.id.btnAddCart);
        }
    }
}
