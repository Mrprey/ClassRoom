package com.example.classroom.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.R
import com.example.classroom.dba.MockData

class DataAdapterView (private val data: List<MockData>) : RecyclerView.Adapter<DataAdapterView.IssueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list, parent, false)
        return IssueViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class IssueViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var cardView = this.itemView.findViewById<CardView>(R.id.cv_Titulo)
        fun bind(example: MockData) {
            var textView_title = this.itemView.findViewById<TextView>(R.id.tv_textTitulo)
            textView_title.text = example.description
            //set ImageView people
           // var imageView_status = this.itemView.findViewById<ImageView>(R.id.iv_status)
        }
    }
}
