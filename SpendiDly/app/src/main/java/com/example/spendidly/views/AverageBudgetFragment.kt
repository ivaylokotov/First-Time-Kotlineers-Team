package com.example.spendidly.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.spendidly.viewmodels.AverageBudgetFragmentViewModel

class AverageBudgetFragment : BudgetFragment() {
    private lateinit var viewModel: AverageBudgetFragmentViewModel

    init {
        headerText = "Your Average Budget"
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
        ).get(AverageBudgetFragmentViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root // TODO: get viewModel and set the superclass binding variable to it
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAverageBudgetX().observe(viewLifecycleOwner, onCacheReceived)
    }
}