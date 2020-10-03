package com.example.spendidly.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.spendidly.R
import com.example.spendidly.viewmodels.UserInputFragmentViewModel

class UserInputFragment : Fragment() {

    companion object {
        fun newInstance() = UserInputFragment()
    }

    private lateinit var viewModel: UserInputFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application))
            .get(UserInputFragmentViewModel::class.java)

        // TODO: Databinding inflate here

        return inflater.inflate(R.layout.fragment_user_input, container, false)
    }

}