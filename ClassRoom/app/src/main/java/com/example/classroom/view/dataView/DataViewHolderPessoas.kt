package com.example.classroom.view.dataView

import android.view.View
import android.widget.TextView
import com.example.classroom.R
import com.example.classroom.model.MockData

class DataViewHolderPessoas(itemView: View) :DataViewHolder(itemView) {

    override fun bind(response: MockData) {
        this.itemView.findViewById<TextView>(R.id.tv_textTitle).text = response.name
    }
}