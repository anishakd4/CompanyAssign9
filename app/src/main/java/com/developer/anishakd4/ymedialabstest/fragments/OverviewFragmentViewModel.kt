package com.developer.anishakd4.ymedialabstest.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.developer.anishakd4.ymedialabstest.models.VariantGroupsModel
import com.developer.anishakd4.ymedialabstest.models.VariationsModel
import com.developer.anishakd4.ymedialabstest.networking.DataApi
import kotlinx.coroutines.*

class OverviewFragmentViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _listItems = MutableLiveData<List<VariantGroupsModel>>()
    val listitems: LiveData<List<VariantGroupsModel>>
        get() = _listItems

    init {
        getVariantsData()
    }

    private fun getVariantsData() {
        coroutineScope.launch {
            val getDataDeferred = DataApi.getDataInterface.getData()
            try {
                val result = getDataDeferred.await()
                Log.i("anisham", "anisham category size= $result")
                _listItems.value = result.variants.variant_groups
            } catch (t: Throwable) {
                Log.i("anisham", "anisham = fail ${t.localizedMessage}")
            }

        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}