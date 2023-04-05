package com.shellcore.android.cache.ui.main.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val _queryResponse = MutableLiveData<Result<Boolean>>()
    val queryResponse: LiveData<Result<Boolean>> = _queryResponse

    fun queryData() {
        viewModelScope.launch {
            delay(2000)
            _queryResponse.value = Result.success(true)
        }
    }
}
