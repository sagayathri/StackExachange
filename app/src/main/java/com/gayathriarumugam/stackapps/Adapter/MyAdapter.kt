package com.gayathriarumugam.stackapps.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gayathriarumugam.stackapps.Data.Model.Items
import com.gayathriarumugam.stackapps.R
import java.util.ArrayList
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(private val mData: ArrayList<Items>, private val listener : Listener) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //Inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    //Binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position], listener)
    }

    //Total number of rows
    override fun getItemCount(): Int = mData.size

    //Gets the item in specified position
    fun getItem(position: Int): Items = mData[position]

    //Stores and recycles views as they are scrolled off screen
    class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Items, listener : Listener) {
            //Listen for user input events
            itemView.setOnClickListener{ listener.onItemClick(item) }
            itemView.reputationTV.text = item.reputation.toString()
            itemView.usernameTV.text = item.displayName
        }
    }

    //Respond to item click events
    interface Listener {
        fun onItemClick(item : Items)
    }
}