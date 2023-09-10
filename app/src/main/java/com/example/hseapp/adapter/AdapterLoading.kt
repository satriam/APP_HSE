package com.example.hseapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.R
import com.example.hseapp.RVLoading
import com.example.hseapp.dao.AnswerEntity

class AdapterLoading(private val context: Context, private val dataList: List<AnswerEntity>): RecyclerView.Adapter<AdapterLoading.ViewHolderData>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderData {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.recent_loading,parent,false)

        return ViewHolderData(layout)
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        val item=dataList[position]

        holder.tanggal.text=item.tanggal
        holder.lokasi.text=item.kondisi1
        holder.status.text= item.status.toString()



    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolderData(itemView: View): RecyclerView.ViewHolder(itemView) {
        val context = itemView.context
        val tanggal : TextView = itemView.findViewById(R.id.tanggal)
        val lokasi: TextView = itemView.findViewById(R.id.tv_lokasi)
        val status :TextView=itemView.findViewById(R.id.tv_status)
    }
}