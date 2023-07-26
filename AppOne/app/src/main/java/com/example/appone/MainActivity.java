package com.example.appone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appone.fragment.HomeFragment;
import com.example.appone.fragment.ExperienceFragment;
import com.example.appone.fragment.ProfileFagment;
import com.example.appone.fragment.PostFragment;
import com.example.appone.fragment.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            if (savedInstanceState == null) {
                loadFragment(new HomeFragment());
            }
            BottomNavigationView bottomNavView;
            bottomNavView = findViewById(R.id.bottomNavView);
            bottomNavView.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if(itemId == R.id.menu_home){
                    loadFragment(new HomeFragment());
                    return true;
                }else if(itemId == R.id.menu_post){
                    loadFragment(new PostFragment());
                    return true;
                }else if(itemId == R.id.menu_experience){
                    loadFragment(new ExperienceFragment());
                    return true;
                }else if(itemId==R.id.menu_profile){
                    loadFragment(new ProfileFagment());
                } else if (itemId==R.id.menu_wallet) {
                    loadFragment(new WalletFragment());

                }

                return false;
            });

        }


        private void loadFragment(Fragment fragment){
              FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        }


    }