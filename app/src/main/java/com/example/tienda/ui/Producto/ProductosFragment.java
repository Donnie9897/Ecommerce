package com.example.tienda.ui.Producto;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienda.R;
import com.example.tienda.adapters.ProductAdapter;
import com.example.tienda.models.ApplicationViewModel;

public class ProductosFragment extends Fragment {

    private ProductosViewModel mViewModel;
    RecyclerView recyclerView;
    ApplicationViewModel applicationViewModel;
    Context context;
    public static ProductosFragment newInstance() {
        return new ProductosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        recyclerView = view.findViewById(R.id.recyclerProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        context = view.getContext();
        recyclerView.setAdapter(new ProductAdapter(view.getContext(),applicationViewModel.getProducts()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProductosViewModel.class);
        // TODO: Use the ViewModel
    }

    //Add button to the recycler view to access modification of an instances
    //Send two values on intent: one for the instance id to find it on database, another to check if it's to modify

    //Add onClick to photo so it inflates viewProduct
    //Add onClick to addCart, that would take productId and userId and create a new instance on the database
    //Check if instance already exist, in that case, increment value by 1

    //Inside viewProduct, check in database if instance exist for userId and productId
    //In that case, get amount and load it in the specific label
    //If user hits add to cart, take amount field and add it to database


}