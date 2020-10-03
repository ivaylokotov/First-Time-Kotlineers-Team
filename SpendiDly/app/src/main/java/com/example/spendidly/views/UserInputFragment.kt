package com.example.spendidly.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.spendidly.R
import com.example.spendidly.databinding.FragmentUserInputBinding
import com.example.spendidly.models.ResponseState
import com.example.spendidly.viewmodels.UserInputFragmentViewModel
import kotlinx.android.synthetic.main.fragment_user_input.*

class UserInputFragment : BaseFragment() {
    private lateinit var viewModel: UserInputFragmentViewModel

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
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit_button.setOnClickListener {
            viewModel.getBudgetX().observe(viewLifecycleOwner, {
                when (it) {
                    is ResponseState.Success -> {
                        val navController = findNavController()
                        navController.navigate(R.id.action_userInputFragment_to_latestBudgetFragment)
                    }
                    is ResponseState.Error.NetworkError -> showToast("Network error: code ${it.errorCode}")
                }
            })
        }

        is_homeowner_switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener(
            fun(_: CompoundButton?, isChecked: Boolean?) {
                viewModel.setIsHomeowner(isChecked!!)
            }
        ))
    }

    private fun showToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()

}