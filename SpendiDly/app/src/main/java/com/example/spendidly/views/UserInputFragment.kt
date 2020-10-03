package com.example.spendidly.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.spendidly.R
import com.example.spendidly.databinding.FragmentUserInputBinding
import com.example.spendidly.utils.Constants
import com.example.spendidly.utils.PredicateTextWatcher
import com.example.spendidly.viewmodels.UserInputFragmentViewModel
import com.google.android.material.textfield.TextInputEditText
import java.util.function.Predicate

class UserInputFragment : BaseFragment() {
    private lateinit var viewModel: UserInputFragmentViewModel

    private lateinit var ageInputEditText: TextInputEditText
    private lateinit var grossIncomeEditText: TextInputEditText
    private lateinit var netIncomeEditText: TextInputEditText
    private lateinit var householdMembersEditText: TextInputEditText
    private lateinit var zipInputEditText: TextInputEditText

    companion object {
        fun newInstance() = UserInputFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentUserInputBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_input, container, false)
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)

        ).get(UserInputFragmentViewModel::class.java)

        val view = binding.root

        initTextFieldValidators(view)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return view
    }

    private fun initTextFieldValidators(view: View) {
        ageInputEditText = view.findViewById(R.id.text_input_age)
        grossIncomeEditText = view.findViewById(R.id.text_input_gross_income)
        netIncomeEditText = view.findViewById(R.id.text_input_net_income)
        householdMembersEditText = view.findViewById(R.id.text_input_household_members)
        zipInputEditText = view.findViewById(R.id.text_input_zip_field)

        // TODO: fix repetition & extract predicates
        ageInputEditText.addTextChangedListener(PredicateTextWatcher(ageInputEditText, Constants.ageInputError, Predicate {
            return@Predicate it.isEmpty() || it.length >= 3 || it.toLong() < 18
        }))

        ageInputEditText.addTextChangedListener(PredicateTextWatcher(ageInputEditText, Constants.incomeInputError, Predicate {
            return@Predicate it.isEmpty() || it.length >= 15 || it.toLong() < 0
        }))

        householdMembersEditText.addTextChangedListener(PredicateTextWatcher(householdMembersEditText, Constants.householdMembersInputError, Predicate {
            return@Predicate it.isEmpty() || it.toLong() < 0
        }))

        netIncomeEditText.addTextChangedListener(PredicateTextWatcher(netIncomeEditText, Constants.incomeInputError, Predicate {
            return@Predicate it.isEmpty() || it.length >= 15 || it.toLong() < 0
        }))

        zipInputEditText.addTextChangedListener(PredicateTextWatcher(zipInputEditText, Constants.zipInputError, Predicate {
            return@Predicate it.isEmpty() || it.length != 5 || it.toLong() < 0
        }))
    }
}