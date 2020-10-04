package com.example.spendidly.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spendidly.R
import com.example.spendidly.databinding.FragmentBudgetBinding
import com.example.spendidly.viewmodels.LatestBudgetFragmentViewModel

// fragment for the latest budget received
class LatestBudgetFragment : BudgetFragment() {
    private lateinit var viewModel: LatestBudgetFragmentViewModel

    init {
        headerText = "Your Latest Budget"
    }

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLatestBudget().observe(viewLifecycleOwner, onCacheReceived)
    }
}