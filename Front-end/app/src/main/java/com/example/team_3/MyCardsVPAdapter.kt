package com.example.team_3

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team_3.databinding.ItemMycardBinding
import java.net.URI

class MyCardsVPAdapter(private val dataList: ArrayList<MyCardData>): RecyclerView.Adapter<MyCardsVPAdapter.PagerViewHolder>() {
    inner class PagerViewHolder(private val viewBinding: ItemMycardBinding): RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data: Int){
            viewBinding.imgMycard.setImageResource(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val viewBinding = ItemMycardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(dataList[position].front)
        var front = true
        holder.itemView.setOnClickListener {
            if(front){
                front = false
                holder.bind(dataList[position].back)
            }else {
                front = true
                holder.bind(dataList[position].front)
            }
        }
    }
    override fun getItemCount(): Int = dataList.size

}
