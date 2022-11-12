package com.example.team_3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team_3.databinding.ItemFriendcardBinding

class friendRVAdapter(private val dataList: ArrayList<Friend>): RecyclerView.Adapter<friendRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val viewBinding: ItemFriendcardBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(position: Int) {
            viewBinding.imgFricard.setImageResource(dataList[position].front)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemFriendcardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = dataList.size
}