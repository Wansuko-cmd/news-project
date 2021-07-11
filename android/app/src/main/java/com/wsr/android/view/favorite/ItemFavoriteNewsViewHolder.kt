package com.wsr.android.view.favorite

import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ItemFavoriteNewsHeaderBinding

class ItemFavoriteNewsViewHolder(binding: ItemFavoriteNewsHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
    val view = binding.root
    val title = binding.title
}
