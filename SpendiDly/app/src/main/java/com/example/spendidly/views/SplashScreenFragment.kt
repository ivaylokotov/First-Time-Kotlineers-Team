package com.example.spendidly.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.Handler
import androidx.navigation.fragment.findNavController
import com.example.spendidly.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = requireActivity()
        val bottomNav = activity.findViewById<BottomNavigationView>(R.id.bottom_nav)
        val actionBar = activity.actionBar

        bottomNav.visibility = View.GONE
        actionBar?.hide()

        // Navigate to input fragment after 3 seconds
        view?.postDelayed({
            bottomNav.visibility = View.VISIBLE
            actionBar?.show()

            findNavController().navigate(R.id.action_splashScreenFragment_to_userInputFragment)
        }, 3000)
    }
}