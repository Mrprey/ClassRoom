package com.example.classroom.ui.atividades

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AtividadesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Atividades Fragment"
    }
    val text: LiveData<String> = _text
}