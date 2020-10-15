package com.giniapps.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.giniapps.model.api_model.PastebinResponseModel
import com.giniapps.model.viewholder_model.PastebinModelWithZeroIndicator
import com.giniapps.network.respository.MainRepository
import com.giniapps.utils.network.ResponseHandler

class MainViewModel(private val repository: MainRepository) : ViewModel() {


    val allNumbers: LiveData<ResponseHandler.Resource<PastebinResponseModel>> =
        liveData {
            emit(ResponseHandler.Resource.loading(null))
            emit(repository.getAllNumbers())
        }


    /**
     * This method converts the raw data we get from the API into
     * data we can use in our ViewHolder classes.
     */
    fun pastebinDataToViewHolderData(model : PastebinResponseModel) : List<PastebinModelWithZeroIndicator> {
        val numbers: MutableList<Int> = mutableListOf()
        model.numbers.forEach { numbers.add(it.number) }
        val viewHolderList = mutableListOf<PastebinModelWithZeroIndicator>()
        numbers.forEach { number ->
            if (number != 0 && numbers.contains(-number)) {
                viewHolderList.add(PastebinModelWithZeroIndicator(number, true))
            } else {
                viewHolderList.add(PastebinModelWithZeroIndicator(number, false))
            }
        }
        viewHolderList.sortBy { it.value }
        return viewHolderList
    }
}

