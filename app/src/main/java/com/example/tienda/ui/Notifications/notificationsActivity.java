package com.example.tienda.ui.Notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienda.LoginActivity;
import com.example.tienda.R;
import com.example.tienda.databinding.ActivityNotificationsBinding;
import com.example.tienda.databinding.ActivityRegisterBinding;
import com.example.tienda.models.ApplicationViewModel;

public class notificationsActivity extends AppCompatActivity {
    private RecyclerView recycler_aux;
    private TextView txt;

    private ActivityNotificationsBinding binding;
    ApplicationViewModel applicationViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_notifications);

        binding = ActivityNotificationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);
        recycler_aux = binding.recyclerNotifications;
        txt = binding.notifications;

    }

    public void notifications(View view){
        RecyclerView r_aux = recycler_aux;
        TextView aux = txt;

        Toast.makeText(this, "Notifications Activity", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, notificationsActivity.class);
        startActivity(intent);

    }
}