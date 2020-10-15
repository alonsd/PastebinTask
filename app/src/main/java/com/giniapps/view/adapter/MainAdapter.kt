package com.giniapps.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.giniapps.databinding.ViewholderOrangeBinding
import com.giniapps.databinding.ViewholderRedBinding
import com.giniapps.model.viewholder_model.PastebinModelWithZeroIndicator
import com.giniapps.utils.Constants.ViewHolderTypes.ORANGE
import com.giniapps.utils.Constants.ViewHolderTypes.RED
import com.giniapps.utils.adapter.DefaultAdapterDiffUtilCallback
import com.giniapps.view.adapter.holder.OrangeViewHolder
import com.giniapps.view.adapter.holder.RedViewHolder

class MainAdapter(private val context: Context) :
    androidx.recyclerview.widget.ListAdapter<PastebinModelWithZeroIndicator, RecyclerView.ViewHolder>(
        DefaultAdapterDiffUtilCallback<PastebinModelWithZeroIndicator>()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == RED) {
            val redBinding =
                ViewholderRedBinding.inflate(LayoutInflater.from(context), parent, false)
            RedViewHolder(redBinding)
        } else {
            val orangeBinding =
                ViewholderOrangeBinding.inflate(LayoutInflater.from(context), parent, false)
            OrangeViewHolder(orangeBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RedViewHolder -> {
                holder.bind(getItem(position).value)
            }
            is OrangeViewHolder -> {
                holder.bind(getItem(position).value)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).isCoupleAvailable) RED else ORANGE
    }
}