package com.example.classroom.view.mural

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MuralViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mural Fragment"
    }
    val text: LiveData<String> = _text
}