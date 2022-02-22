package com.example.classroom.view.dataView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.model.MockData

abstract class DataViewHolder protected constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
    //var cardView = this.itemView.findViewById<CardView>(R.id.cv_Titulo)
    abstract fun bind(response: MockData)
}