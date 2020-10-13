package com.giniapps.network.respository

import com.giniapps.model.viewholder_model.PastebinModelWithZeroIndicator
import com.giniapps.network.api.PastebinNetwork
import kotlin.math.abs


class MainRepository {


    /**
     * This function fetches the model received from the network layer and translates it to
     * our RecyclerView model.
     */
    suspend fun getAllNumbers(): MutableList<PastebinModelWithZeroIndicator>? {
        val response = PastebinNetwork.getNumbers()
        if (!response.isSuccessful)
            return null
        val numbers: MutableList<Int> = mutableListOf()
        response.body()!!.numbers.forEach { numbers.add(it.number) }
        val viewHolderList = mutableListOf<PastebinModelWithZeroIndicator>()
        numbers.forEach { number ->
            val tempList = numbers.toMutableList()
            tempList.removeAt(numbers.indexOf(number))
            if (tempList.contains(abs(number)) || tempList.contains(number)) {
                viewHolderList.add(PastebinModelWithZeroIndicator(number, true))
                viewHolderList.add(PastebinModelWithZeroIndicator(-number, true))
            } else {
                viewHolderList.add(PastebinModelWithZeroIndicator(number, false))
            }
        }
        viewHolderList.sortBy { it.value }
        return viewHolderList
    }
}