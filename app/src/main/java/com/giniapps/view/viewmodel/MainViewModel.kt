package com.giniapps.view.viewmodel

import androidx.lifecycle.*
import com.giniapps.model.api_model.PastebinResponseModel
import com.giniapps.model.viewholder_model.PastebinModelWithZeroIndicator
import com.giniapps.network.respository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {


    fun getAllNumbers(): LiveData<List<PastebinModelWithZeroIndicator>?> {

        val results = MutableLiveData<List<PastebinModelWithZeroIndicator>?>()
        viewModelScope.launch(Dispatchers.IO) {
            val allNumbers = repository.getAllNumbers()
            withContext(Dispatchers.Main) {
                results.value = allNumbers
            }
        }
        return results
    }

}