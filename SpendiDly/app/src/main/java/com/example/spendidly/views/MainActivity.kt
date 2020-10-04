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
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import android.transition.AutoTransition
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spendidly.R
import com.example.spendidly.adapters.DemographicsXAdapter
import com.example.spendidly.databinding.MainActivityBinding
import com.example.spendidly.viewmodels.LatestBudgetFragmentViewModel
import com.example.spendidly.viewmodels.MainActivityViewModel
import com.example.test.data.DemographicsX

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(MainActivityViewModel::class.java)
        navController = findNavController(R.id.nav_host_fragment)

        binding.bottomNav.setupWithNavController(navController)

        // configures which fragments are the top-level ones
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.userInputFragment, R.id.latestBudgetFragment, R.id.averageBudgetFragment),
            binding.drawerLayout
        )

        // setup bottomNav
        binding.navView.setupWithNavController(navController)

        // Setup drawer with the actionBar
        setupActionBarWithNavController(navController, appBarConfiguration)

        val recyclerView = findViewById<RecyclerView>(R.id.past_demographics_recycler_view)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getAllDemographics().observe(this, {
            if(it != null) {
                if(recyclerView.adapter == null) {
                    recyclerView.adapter = DemographicsXAdapter(it)
                } else {
                    (recyclerView.adapter as DemographicsXAdapter).setDemographicsX(it)
                }
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave?")
                .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                    finish()
                }
                .setNegativeButton("No") { dialogInterface: DialogInterface, _: Int ->
                    dialogInterface.dismiss()
                }
                .setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .create()
                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
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