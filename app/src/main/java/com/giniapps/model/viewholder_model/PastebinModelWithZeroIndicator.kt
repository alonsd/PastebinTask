package com.giniapps.model.viewholder_model

import com.giniapps.utils.adapter.DefaultAdapterDiffUtilCallback

data class PastebinModelWithZeroIndicator(
    val value: Int,
    val isCoupleAvailable: Boolean
) : DefaultAdapterDiffUtilCallback.ModelWithId {
    override fun fetchId(): Int = value
}