package dev.jp.parcial.ui.GenSub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import dev.jp.parcial.R

class GeneracionSub(private var lstGEN: List<modelgen>) :
        RecyclerView.Adapter<GeneracionSub.ViewHolder>(){
            class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
                val imgGEN : ImageView = itemView.findViewById(R.id.imgGEN)
                val tipGEN : TextView = itemView.findViewById(R.id.tipGEN)
                val añoGEN : TextView = itemView.findViewById(R.id.añoGEN)
            }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneracionSub.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater
                .inflate(R.layout.subgen
                ,parent
                ,false)

        )
    }

    override fun onBindViewHolder(holder: GeneracionSub.ViewHolder, position: Int) {
        val itemsong = lstGEN[position]
        holder.imgGEN.setImageResource(itemsong.image)
        holder.añoGEN.text = itemsong.aniogen
        holder.tipGEN.text =  itemsong.tipogen

    }

    override fun getItemCount(): Int {
        return lstGEN.size
    }

}

