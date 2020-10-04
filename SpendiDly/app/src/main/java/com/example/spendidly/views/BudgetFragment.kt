package com.example.spendidly.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.spendidly.R
import com.example.spendidly.databinding.FragmentBudgetBinding
import com.example.spendidly.databinding.FragmentBudgetWrapperBinding
import com.example.test.data.BudgetX
import org.kodein.di.KodeinAware

// abstract fragment for fragments using the fragment_budget_wrapper layout
// will prolly need this given how similar the fragments will be but delete this if not
abstract class BudgetFragment : Fragment() {
    lateinit var binding: FragmentBudgetWrapperBinding
    lateinit var onCacheReceived: Observer<BudgetX?>
    lateinit var headerText: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_budget_wrapper, container, false)
        binding.lifecycleOwner = this
        binding.headerText = headerText
        // TODO: set databinding fields
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCacheReceived = Observer {
            if (it != null && it.isValid()) {
                view.findViewById<ScrollView>(R.id.fragment_results).visibility =
                    View.VISIBLE // enable inner layout
                view.findViewById<TextView>(R.id.empty_api_text).visibility =
                    View.INVISIBLE // disable outer layout
            }
        }
    }

}