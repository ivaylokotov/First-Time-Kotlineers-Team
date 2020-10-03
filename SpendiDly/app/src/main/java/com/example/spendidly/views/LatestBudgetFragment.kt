package com.example.spendidly.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.spendidly.R
import com.example.spendidly.databinding.FragmentBudgetBinding
import com.example.spendidly.viewmodels.LatestBudgetFragmentViewModel

// fragment for the latest budget received
class LatestBudgetFragment : BudgetFragment() {
    private lateinit var viewModel: LatestBudgetFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        ).get(LatestBudgetFragmentViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root // TODO: get viewModel and set the superclass binding variable to it
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLatestBudget().observe(viewLifecycleOwner, onCacheReceived)
    }
}