package com.example.spendidly.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.spendidly.R
import com.example.spendidly.databinding.FragmentBudgetBinding
import org.kodein.di.KodeinAware

// abstract fragment for fragments using the fragment_budget_wrapper layout
// will prolly need this given how similar the fragments will be but delete this if not
abstract class BudgetFragment : BaseFragment() {
    lateinit var binding: FragmentBudgetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_budget_wrapper, container, false)
        binding.lifecycleOwner = this
        // TODO: set databinding fields
        return binding.root
    }

}