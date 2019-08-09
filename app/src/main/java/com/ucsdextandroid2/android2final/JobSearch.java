package com.ucsdextandroid2.android2final;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class JobSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_search);
        setUpBottomNavBar();


    }
    private void setUpBottomNavBar() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.ai_bottom_nav_view);

        NavController navController = Navigation
                .findNavController(this, R.id.ai_nav_host);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        // AlternativeNavigationUI.setupWithNavController(bottomNavigationView, navController);

        //findNavController from host id
    }
}
