package com.example.classroom.view.dataView

import android.view.View
import android.widget.TextView
import com.example.classroom.R
import com.example.classroom.model.MockData

class DataViewHolderAtividades(itemView: View) : DataViewHolder(itemView) {
    override fun bind(response: MockData) {
        this.itemView.findViewById<TextView>(R.id.tv_textTitle).text = response.name
        try {
            this.itemView.findViewById<TextView>(R.id.tv_textDate).text = response.date
            this.itemView.findViewById<TextView>(R.id.tv_textDescription).text = response.description
        }catch(e: Exception) {
            print("error no mock de atividades")
        }
    }
}
