package com.giniapps.view.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.giniapps.databinding.ViewholderRedBinding

class RedViewHolder(private val binding : ViewholderRedBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(number : Int){
        binding.orangeViewholderNumbersButton.text = number.toString()
    }
}