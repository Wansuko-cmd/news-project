package com.wsr.android.view.favorite

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ItemFavoriteNewsHeaderBinding
import com.wsr.android.view.show.ShowActivity
import com.wsr.model.db.entities.Favorite
import core.entities.Article

class FavoriteAdapter(private val activity: FavoriteActivity) : RecyclerView.Adapter<ItemFavoriteNewsViewHolder>() {

    private var favorites = listOf<Favorite>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFavoriteNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemFavoriteNewsViewHolder(ItemFavoriteNewsHeaderBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    override fun onBindViewHolder(holder: ItemFavoriteNewsViewHolder, position: Int) {

        holder.view.setOnClickListener {
            val intent = Intent(activity, ShowActivity::class.java)
            intent.putExtra("url", favorites[position].url)
            activity.startActivity(intent)
        }

        holder.view.setOnLongClickListener {
            AlertDialog.Builder(activity)
                .setTitle("警告")
                .setMessage("お気に入りから削除しますか？")
                .setPositiveButton("はい"){ _, _ ->
                    activity.deleteFavorite(favorites[position].id)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("いいえ", null)
                .show()

            true
        }

        holder.title.text = favorites[position].title
    }

    fun setArticles(articles: List<Favorite>){
        this.favorites = articles
        notifyDataSetChanged()
    }
}
