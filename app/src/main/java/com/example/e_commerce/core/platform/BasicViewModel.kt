package com.example.e_commerce.core.platform

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.e_commerce.core.failure.Failure

abstract class BasicViewModel : ViewModel() {
    var failure by mutableStateOf<Failure?>(null)
        private set

    protected fun handleFailure(failure: Failure) {
        this.failure = failure
    }
}