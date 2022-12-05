package com.example.tienda.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tienda.Product;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private Product producto;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
    //    mText.setValue("Teclado");

        producto = new Product("Teclado","Un teclado RGB GAMER","120$");

    }

    public LiveData<String> getText() {
        return mText;
    }
}