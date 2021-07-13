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


        holder.view.apply{

            //記事の参照
            setOnClickListener {
                val intent = Intent(activity, ShowActivity::class.java)
                intent.putExtra("url", articles[position].url)
                activity.startActivity(intent)
            }

            //記事のお気に入り削除機能
            setOnLongClickListener {
                activity.insertFavorite(articles[position])
                true
            }
        }

        //画像の読み込み
        Picasso
            .get()
            .load(articles[position].urlToImage)
            .placeholder(R.drawable.logo_kotlin_ex)
            .into(holder.thumbnail)

        
        holder.title.text = articles[position].title ?: ""
    }

    //記事の更新処理
    fun setArticles(articles: List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }
}
