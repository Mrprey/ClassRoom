package com.example.classroom.view.dataView.dataAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.classroom.R
import com.example.classroom.controller.Controller
import com.example.classroom.view.dataView.DataAdapter
import com.example.classroom.view.dataView.DataViewHolder
import com.example.classroom.view.dataView.DataViewHolderArquivos

class AdapterMural(controller: Controller) : DataAdapter(controller) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_arquivos, parent, false)
        return DataViewHolderArquivos(view)
    }
}