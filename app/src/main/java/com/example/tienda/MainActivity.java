package com.example.tienda;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.tienda.classes.Category;
import com.example.tienda.ui.Cart.CartActivity;
import com.example.tienda.ui.Cart.CartFragment;
import com.example.tienda.ui.Notifications.notificationsActivity;

import com.google.android.material.snackbar.Snackbar;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tienda.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        /*binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_productos, R.id.nav_profile)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bar_carrito:
                // write your code here
                Intent cartActivity = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(cartActivity);

                return true;

            case R.id.bar_notifications:
                // write your code here
                Intent notificationsActivity = new Intent(getApplicationContext(), notificationsActivity.class);
                startActivity(notificationsActivity);

                return true;

            case R.id.action_search:
                // write your code here
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    //Se usa en el fragmento de producto, pero hay que definirlo en la actividad padre
    public void regProduct(View view){
        Intent intent = new Intent(this, productFormActivity.class);
        startActivity(intent);
    }

    //Se usa en el fragmento de category, pero hay que definirlo en la actividad padre
    public void regCat(View view){
        Intent intent = new Intent(this, CategoryFormActivity.class);
        startActivity(intent);
    }

    public void saveProfileData(View view){

    }

}