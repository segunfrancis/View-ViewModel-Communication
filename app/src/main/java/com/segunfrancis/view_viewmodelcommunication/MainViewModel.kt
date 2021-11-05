package com.segunfrancis.view_viewmodelcommunication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var count: Int = 0

    private var _countState = MutableLiveData<CountState<Int>>(CountState.Success(count))
    val countState: LiveData<CountState<Int>> = _countState

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("MainViewModel", "Error: ${throwable.localizedMessage}")
    }

    fun addCount() = viewModelScope.launch(exceptionHandler) {
        if (count >= 10) {
            _countState.value = CountState.Warning("Maximum value reached", count)
        } else {
            count++
            _countState.value = CountState.Success(count)
        }
    }

    fun subtractCount() = viewModelScope.launch(exceptionHandler) {
        if (count <= 0) {
            _countState.value = CountState.Warning("Minimum value reached", count)
        } else {
            count--
            _countState.value = CountState.Success(count)
        }
    }
}
