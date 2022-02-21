package com.example.classroom.view.dataAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.R

class DataAdapter(private val data: MutableList<String>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_atividades, parent, false)
        return DataViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //var cardView = this.itemView.findViewById<CardView>(R.id.cv_Titulo)
        fun bind(example: String) {
            var textView_title = this.itemView.findViewById<TextView>(R.id.tv_textTitle)
            textView_title.text = example
            //set ImageView people
           // var imageView_status = this.itemView.findViewById<ImageView>(R.id.iv_status)
        }
    }
}
