package com.shaon2016.meldcxandroidtest.view.secondary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shaon2016.meldcxandroidtest.base.BaseViewModel
import com.shaon2016.meldcxandroidtest.data.DataManager
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondaryVM @Inject constructor(dataManager: DataManager) : BaseViewModel() {

    private val dao = dataManager.roomHelper.getDatabase().historyDao()

    val histories = MutableLiveData<List<History>>()

    init {
        viewModelScope.launch {
            dao.all().collect {
                histories.value = it
            }
        }
    }

    fun remove(history: History) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.delete(history)
        }
    }
}