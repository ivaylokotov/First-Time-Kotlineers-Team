package com.example.spendidly.views

import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import android.transition.AutoTransition
import androidx.appcompat.app.AlertDialog
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

    override fun onBackPressed() {
        super.onBackPressed()
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to leave?")
            .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                finish()
            }
            .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }
            .setIcon(R.drawable.ic_baseline_exit_to_app_24)
            .create()
            .show()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun onBudgetCardButtonTapped(view: View) {
        // TODO: Method to respond to taps on budget result cards (expand view & show subcard)
        val cardViewLayout: ConstraintLayout = view.parent.parent as ConstraintLayout

        val subCardLayout: ConstraintLayout = cardViewLayout.findViewById(R.id.subCardConstraintLayout)
        
        if(subCardLayout.visibility == View.GONE) {
            val cardView = cardViewLayout.parent as CardView

            TransitionManager.beginDelayedTransition(cardView, AutoTransition())
            subCardLayout.visibility = View.VISIBLE
            (view as Button).setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
        } else {
            subCardLayout.visibility = View.GONE
            (view as Button).setBackgroundResource(R.drawable.ic_baseline_chevron_right_24)
        }
    }
}