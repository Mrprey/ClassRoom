package com.example.classroom.ui.arquivos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArquivosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Arquivos Fragment"
    }
    val text: LiveData<String> = _text
}