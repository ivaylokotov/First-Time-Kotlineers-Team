package com.example.spendidly.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spendidly.R
import org.kodein.di.KodeinAware

// abstract fragment for fragments using the fragment_budget_wrapper layout
// will prolly need this given how similar the fragments will be but delete this if not
abstract class BudgetFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // TODO: Databinding inflate here

        return inflater.inflate(R.layout.fragment_budget_wrapper, container, false)
    }

}