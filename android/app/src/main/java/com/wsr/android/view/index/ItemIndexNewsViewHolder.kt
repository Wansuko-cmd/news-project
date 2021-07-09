package com.wsr.android.view.index

import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ItemIndexNewsHeaderBinding

class ItemIndexNewsViewHolder(
    binding: ItemIndexNewsHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    val view = binding.root
    val title = binding.title
    val thumbnail = binding.indexThumbnail
}
