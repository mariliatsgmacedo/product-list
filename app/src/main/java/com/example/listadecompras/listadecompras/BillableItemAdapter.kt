package com.example.listadecompras.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import java.util.*

class BillableItemAdapter(private var mList: ArrayList<String>, var listener:BillableItemListener? = null):RecyclerView.Adapter<BillableItemAdapter.ViewHolder>() {

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

        holder.contentCard.setOnLongClickListener {
            listener?.onBillableItemLongClick(item, position)
            true
        }
    }

    fun add(item:String){
        mList.add(item)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        mList.removeAt(position)
        notifyDataSetChanged()
    }


    class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.item_name)
        val contentCard: MaterialCardView = view.findViewById(R.id.content_billable_item)
    }

    interface BillableItemListener{
        fun onBillableItemLongClick(item:String,position: Int)
    }
}