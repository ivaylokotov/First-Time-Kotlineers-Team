package com.example.spendidly.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.spendidly.R
import com.example.spendidly.databinding.FragmentBudgetBinding

// fragment for the latest budget received
class LatestBudgetFragment : BudgetFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root // TODO: get viewModel and set the superclass binding variable to it
    }
}