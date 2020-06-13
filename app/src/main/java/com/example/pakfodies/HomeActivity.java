package com.example.pakfodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.pakfodies.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityHomeBinding.inflate(getLayoutInflater());
       setContentView(mBinding.getRoot());
     NavController controller=Navigation.findNavController(this,R.id.fragment_host);
     NavigationUI.setupWithNavController(mBinding.bottomNavView,controller);

    }
}