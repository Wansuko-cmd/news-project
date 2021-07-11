package com.wsr.android.view.index

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.wsr.android.R
import com.wsr.android.databinding.ItemIndexNewsHeaderBinding
import com.wsr.android.view.show.ShowActivity
import core.entities.Article

class IndexAdapter(
    private val activity: IndexActivity
    ) : RecyclerView.Adapter<ItemIndexNewsViewHolder>() {

    private var articles: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemIndexNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemIndexNewsViewHolder(ItemIndexNewsHeaderBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ItemIndexNewsViewHolder, position: Int) {

        holder.view.setOnClickListener {
            val intent = Intent(activity, ShowActivity::class.java)
            intent.putExtra("url", articles[position].url)
            activity.startActivity(intent)
        }

        holder.view.setOnLongClickListener {
            activity.createFavorite(articles[position])
            true
        }

        Picasso
            .get()
            .load(articles[position].urlToImage)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.thumbnail)

        
        holder.title.text = articles[position].title ?: ""
    }

    fun setArticles(articles: List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }
}
