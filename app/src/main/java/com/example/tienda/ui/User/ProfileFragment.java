package com.example.tienda.ui.User;

import static android.content.Context.MODE_PRIVATE;

import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienda.R;
import com.example.tienda.classes.User;
import com.example.tienda.databinding.FragmentProductosBinding;
import com.example.tienda.databinding.FragmentProfileBinding;
import com.example.tienda.models.ApplicationViewModel;

public class ProfileFragment extends Fragment{

    FragmentProfileBinding binding;
    private ProfileViewModel mViewModel;
    private TextView userName, email, phone, direction;
    private Switch aSwitch;
    User user;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    ApplicationViewModel applicationViewModel;
    SharedPreferences shared;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        applicationViewModel = new ViewModelProvider(this).get(ApplicationViewModel.class);
        shared = this.getActivity().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        binding =  FragmentProfileBinding.inflate(inflater, container, false);

        userName = binding.username;
        email = binding.email;
        phone = binding.phone;
        direction = binding.direction;
        aSwitch = binding.switch1;
        user = applicationViewModel.getUserByid(shared.getInt("userID", 0));
        setData();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _direction = direction.getText().toString();
                Boolean isCheked = aSwitch.isChecked();
                user.setDirection(_direction);
                applicationViewModel.updatetUser(user);
                SharedPreferences.Editor myEdit = shared.edit();
                if(isCheked){
                    myEdit.putBoolean("keepLog", true);
                }else{
                    myEdit.putBoolean("keepLog", false);
                }
                myEdit.apply();
                Toast.makeText(getActivity(), "Changes saved!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setData(){
        userName.setText(user.getUserName());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        direction.setText(user.getDirection());
        aSwitch.setChecked(shared.getBoolean("keepLog",false));
    }
}