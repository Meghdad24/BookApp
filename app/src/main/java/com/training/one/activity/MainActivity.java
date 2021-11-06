package com.training.one.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.training.one.R;
import com.training.one.fragment.HomeFragment;
import com.training.one.fragment.PersonFragment;
import com.training.one.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void setupView() {
        frameLayout = findViewById(R.id.main_frame);
        bottomNavigationView = findViewById(R.id.main_nav_bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new HomeFragment()).commit();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int navId = item.getItemId();

        switch (navId) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new HomeFragment()).commit();
                break;
            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new SearchFragment()).commit();
                break;
            case R.id.person:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,new PersonFragment()).commit();
                break;
        }

        return true;
    }
}