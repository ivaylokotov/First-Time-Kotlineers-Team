package com.example.spendidly.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.spendidly.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // TODO: Disable bottomnav & action bar for splash screen
        bottomNav = findViewById(R.id.bottom_nav)
    }

    override fun onStart() {
        super.onStart()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomNav.setupWithNavController(navController)
    }
}