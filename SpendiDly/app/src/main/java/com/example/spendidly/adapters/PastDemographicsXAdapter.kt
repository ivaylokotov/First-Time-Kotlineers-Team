package com.example.spendidly.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spendidly.R
import com.example.test.data.DemographicsX

class PastDemographicsXAdapter(private var demographicsX: List<DemographicsX>) :
    RecyclerView.Adapter<PastDemographicsXAdapter.DemographicsXViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PastDemographicsXAdapter.DemographicsXViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.past_demographics_card, parent, false)
        return DemographicsXViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PastDemographicsXAdapter.DemographicsXViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return demographicsX.size
    }

    fun setDemographicsX(demographicsX: List<DemographicsX>) {
        this.demographicsX = demographicsX
        notifyDataSetChanged()
    }


    inner class DemographicsXViewHolder(demographicsXView: View) : RecyclerView.ViewHolder(demographicsXView) {
        // var demographicsX: DemographicsX = demographicsXView.demographicsX
    }
}