package com.example.testandroidhomework090124;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.testandroidhomework090124.databinding.ActivityMainBinding;
import com.example.testandroidhomework090124.fragment.FirstFragment;
import com.example.testandroidhomework090124.fragment.SecondFragment;
import com.example.testandroidhomework090124.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        fragmentManager = getSupportFragmentManager();
                firstFragment = (FirstFragment) fragmentManager.getFragments().get(0);
                secondFragment = new SecondFragment();
                thirdFragment = new ThirdFragment();

        binding.btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fc_main, firstFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });


        binding.btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fc_main, secondFragment);
                //fragmentTransaction.remove(fragmentManager.getFragments().get(0));
                //fragmentTransaction.add(R.id.fc_main, new SecondFragment());
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);

            }
        });

        binding.btnF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction()
                        .replace(R.id.fc_main, thirdFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });



    }

}