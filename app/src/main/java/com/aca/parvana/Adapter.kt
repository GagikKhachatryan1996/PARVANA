package com.aca.parvana

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var anvanumList:ArrayList<String>,var gneriList:ArrayList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.example_element,parent,false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return anvanumList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.anvanum.text=anvanumList[position]
        holder.gumar.text=gneriList[position]

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        var anvanum: TextView=itemView.findViewById(R.id.anvanum)
        var gumar: TextView=itemView.findViewById(R.id.gumar)




    }






}