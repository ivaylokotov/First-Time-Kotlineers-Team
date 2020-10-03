package com.example.spendidly.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spendidly.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // TODO: Disable bottomnav & action bar for splash screen
    }
}