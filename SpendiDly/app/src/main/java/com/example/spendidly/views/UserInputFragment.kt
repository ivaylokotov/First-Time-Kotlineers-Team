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
import com.example.spendidly.viewmodels.UserInputFragmentViewModel

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

}