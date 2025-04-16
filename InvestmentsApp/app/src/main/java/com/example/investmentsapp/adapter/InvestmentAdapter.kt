package com.example.investmentsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.investmentsapp.R
import com.example.investmentsapp.domain.model.Investment

class InvestmentAdapter(
    private val items: List<Investment>,
    private val onItemClick: (Investment) -> Unit
) : RecyclerView.Adapter<InvestmentAdapter.InvestmentViewHolder>() {

    inner class InvestmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtAssetType: TextView = view.findViewById(R.id.txtAssetType)
        val txtTicker: TextView = view.findViewById(R.id.txtTicker)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_investment, parent, false)
        return InvestmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: InvestmentViewHolder, position: Int) {
        val investment = items[position]
        holder.txtAssetType.text = investment.assetType
        holder.txtTicker.text = investment.ticker
        holder.txtPrice.text = "$${investment.currentPrice}"

        holder.itemView.setOnClickListener {
            onItemClick(investment)
        }
    }

    override fun getItemCount(): Int = items.size
}
