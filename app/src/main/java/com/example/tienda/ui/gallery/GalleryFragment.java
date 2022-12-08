package com.example.tienda.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda.CategoryFormActivity;
import com.example.tienda.R;
import com.example.tienda.adapters.CategoryAdapter;
import com.example.tienda.adapters.ProductAdapter;
import com.example.tienda.databinding.FragmentGalleryBinding;
import com.example.tienda.models.ApplicationViewModel;
import com.example.tienda.ui.Producto.ProductosViewModel;

import org.jetbrains.annotations.Nullable;

public class GalleryFragment extends Fragment {

    private GalleryViewModel mViewModel;
    RecyclerView recyclerView;
    ApplicationViewModel applicationViewModel;
    Context context;

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = view.findViewById(R.id.recyclerGallery);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        context = view.getContext();
        recyclerView.setAdapter(new CategoryAdapter(view.getContext(),applicationViewModel.getCategories()));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        // TODO: Use the ViewModel

    }

    public void regCat(View view){
        Intent intent = new Intent(getActivity(), CategoryFormActivity.class);
        startActivity(intent);
    }


}