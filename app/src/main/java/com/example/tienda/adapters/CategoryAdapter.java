package com.example.tienda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.R;
import com.example.tienda.classes.Category;
import com.example.tienda.classes.Product;
import com.example.tienda.models.ApplicationViewModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private final Context context;
    private List<Category> categoryList;
    ApplicationViewModel applicationViewModel;

    public CategoryAdapter(Context context, List<Category>categories) {
        this.context = context;
        categoryList = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_category, parent, false);
        return new CategoryAdapter.CategoryViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        if (categoryList != null) {

            Category current = categoryList.get(position);
            holder.name.setText(current.getName());

        } else {
            holder.name.setText("No Products");
        }
    }


    @Override
    public int getItemCount() {
        if (categoryList != null)
            return categoryList.size();
        else return 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView name, description, price;

        private CategoryViewHolder(View itemView)  {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }

    }
}
