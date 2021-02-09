package com.example.listadecompras.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class BillableItemAdapter(private var mList: ArrayList<String>):RecyclerView.Adapter<BillableItemAdapter.ViewHolder>() {

    private lateinit var context:Context

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_billable_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = mList[position]
        holder.itemName.text = item
    }

    fun add(item:String){
        mList.add(item)
        notifyDataSetChanged()
    }


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.item_name)
    }
}