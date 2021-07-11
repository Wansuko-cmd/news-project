package com.wsr.android.view.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ItemFavoriteNewsHeaderBinding
import core.entities.Article

class FavoriteAdapter : RecyclerView.Adapter<ItemFavoriteNewsViewHolder>() {

    private var articles = listOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFavoriteNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemFavoriteNewsViewHolder(ItemFavoriteNewsHeaderBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ItemFavoriteNewsViewHolder, position: Int) {
        holder.title.text = articles[position].title
    }

    fun setArticles(articles: List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }
}
