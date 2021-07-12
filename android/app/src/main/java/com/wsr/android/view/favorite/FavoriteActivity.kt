package com.wsr.android.view.favorite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ActivityFavoriteBinding
import com.wsr.android.view_model.favorite.FavoriteViewModel

class FavoriteActivity : AppCompatActivity() {

    private var _binding: ActivityFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var activityFavoriteRecyclerView: RecyclerView

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoriteAdapter = FavoriteAdapter(this)

        val divider = DividerItemDecoration(
            this,
            LinearLayoutManager(this).orientation
        )

        activityFavoriteRecyclerView = binding.activityFavoriteRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteAdapter
            addItemDecoration(divider)
        }

        favoriteViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(FavoriteViewModel::class.java).apply {

            favorite.observe(this@FavoriteActivity){
                favoriteAdapter.setArticles(it)
            }
        }
    }

    fun deleteFavorite(id: Int){
        favoriteViewModel.deleteFavorite(id)
    }
}
