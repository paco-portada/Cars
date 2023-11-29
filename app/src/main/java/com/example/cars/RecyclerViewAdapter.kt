package com.example.cars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.RecyclerViewAdapter.MyViewHolder

class RecyclerViewAdapter(
    private val list: List<DataModel>,
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = list.get(position).title
        holder.itemView.setOnClickListener(View.OnClickListener {
            clickListener.onItemClick(
                list[position]
            )
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleTextView: TextView

        init {
            titleTextView = view.findViewById(R.id.titleTextView)
        }
    }

    interface ItemClickListener {
        fun onItemClick(dataModel: DataModel)
    }
}