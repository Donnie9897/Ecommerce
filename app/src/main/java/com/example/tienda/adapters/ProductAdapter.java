package com.example.tienda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.R;
import com.example.tienda.classes.Product;
import com.example.tienda.models.ApplicationViewModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private final Context context;
    private List<Product> productList;
    ApplicationViewModel applicationViewModel;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        productList = products;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ProductViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (productList != null) {
            System.out.println(productList.get(0).getName());

            Product current = productList.get(position);
            holder.name.setText(current.getName());
            holder.price.setText("Price: " + Float.toString(current.getPrice()));
            holder.description.setText(current.getDescription());
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

        private ProductViewHolder(View itemView)  {
            super(itemView);
            name = itemView.findViewById(R.id.categoria_desc);
            price = itemView.findViewById(R.id.price_add);
            description = itemView.findViewById(R.id.description);
        }
    }
}
