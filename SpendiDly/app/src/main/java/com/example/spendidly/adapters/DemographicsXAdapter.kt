package com.example.spendidly.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spendidly.R
import com.example.spendidly.databinding.DemographicsCardBinding
import com.example.test.data.DemographicsX

class DemographicsXAdapter(private var demographicsX: List<DemographicsX>) :
    RecyclerView.Adapter<DemographicsXAdapter.DemographicsXViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DemographicsXAdapter.DemographicsXViewHolder {
        val binding: DemographicsCardBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.demographics_card,
            parent,
            false
        )
        return DemographicsXViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DemographicsXAdapter.DemographicsXViewHolder,
        position: Int
    ) {
        holder.demographicsBinding.demographicsX = demographicsX[position]
    }

    override fun getItemCount(): Int {
        return demographicsX.size
    }

    fun setDemographicsX(demographicsX: List<DemographicsX>) {
        this.demographicsX = demographicsX
        notifyDataSetChanged()
    }


    inner class DemographicsXViewHolder(demographicsXBinding: DemographicsCardBinding)
        : RecyclerView.ViewHolder(demographicsXBinding.root) {
        var demographicsBinding: DemographicsCardBinding = demographicsXBinding
    }
}