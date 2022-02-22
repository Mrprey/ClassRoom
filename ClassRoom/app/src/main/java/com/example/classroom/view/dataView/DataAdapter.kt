package com.example.classroom.view.dataView

import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.controller.Controller

abstract class DataAdapter(private val controller: Controller) : RecyclerView.Adapter<DataViewHolder>() {

    private val list = controller.getData()

    override fun getItemCount() = controller.getSize() - 1

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
