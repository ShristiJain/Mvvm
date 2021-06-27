package com.example.mvvmapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_view.view.*

class recycler_adapter : RecyclerView.Adapter<recycler_adapter.MyViewHolder>() {

    private  var list : List<Data>?=null

    fun setData(list1: List<Data>)
    {
        list = list1
        notifyDataSetChanged()
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.content_view,parent,false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {

            if(list != null)
            return list!!.size
            else
                return 0
        }

        override fun onBindViewHolder(holder:MyViewHolder, position: Int) {

            holder.exchange_id.text = "Exchange_id : " + (list!!.get(position).exchange_id.toString())
            holder.symbol.text = "Sysmbol : " +list!!.get(position).symbol.toString()
            holder.price_unconverted.text = "Price_unconverted : " +list!!.get(position).price_unconverted.toString()
            holder.price.text = "Price : " +list!!.get(position).price.toString()
            holder.change_24.text = "Change_24h : " +list!!.get(position).change_24h.toString()
            holder.spread.text = "Spread : " +list!!.get(position).spread.toString()
            holder.volume.text = "Volume_24h : " + list!!.get(position).volume_24h.toString()
            holder.status.text = "Status : " + list!!.get(position).status.toString()
            holder.time.text = "Time : " + list!!.get(position).time.toString()
        }

        class MyViewHolder(item: View) : RecyclerView.ViewHolder(item)
        {
            val exchange_id: TextView = item.findViewById(R.id.exchange_id_2)
            val symbol : TextView = item.findViewById(R.id.symbol_2)
            val price_unconverted: TextView = item.findViewById(R.id.price_unconverted_2)
            val price: TextView = item.findViewById(R.id.price_2)
            val change_24: TextView = item.findViewById(R.id.change_24_2)
            val spread: TextView = item.findViewById(R.id.spread_2)
            val volume: TextView = item.findViewById(R.id.volume_24_2)
            val status: TextView = item.findViewById(R.id.status_2)
            val time: TextView = item.findViewById(R.id.time_2)

        }
    }
