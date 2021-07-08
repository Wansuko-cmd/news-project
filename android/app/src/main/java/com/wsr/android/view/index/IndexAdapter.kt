package com.wsr.android.view.index

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ItemIndexNewsHeaderBinding

class IndexAdapter : RecyclerView.Adapter<ItemIndexNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemIndexNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemIndexNewsViewHolder(ItemIndexNewsHeaderBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ItemIndexNewsViewHolder, position: Int) {

    }
}