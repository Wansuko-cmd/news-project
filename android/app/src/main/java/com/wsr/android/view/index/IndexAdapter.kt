package com.wsr.android.view.index

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ItemIndexNewsHeaderBinding
import core.entities.Article

class IndexAdapter : RecyclerView.Adapter<ItemIndexNewsViewHolder>() {

    private var articles: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemIndexNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemIndexNewsViewHolder(ItemIndexNewsHeaderBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ItemIndexNewsViewHolder, position: Int) {
        holder.title.text = articles[position].title ?: ""
    }

    fun setArticles(articles: List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }
}
