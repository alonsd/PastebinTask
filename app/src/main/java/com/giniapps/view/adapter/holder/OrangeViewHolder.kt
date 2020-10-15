package com.giniapps.view.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.giniapps.databinding.ViewholderOrangeBinding

class OrangeViewHolder(
    private val binding: ViewholderOrangeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(number : Int) {
        binding.orangeViewholderNumbersButton.text = number.toString()
    }
}