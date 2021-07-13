package com.wsr.android.view.index

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.R
import com.wsr.android.databinding.ActivityIndexBinding
import com.wsr.android.view.favorite.FavoriteActivity
import com.wsr.android.view.settings.SettingsActivity
import com.wsr.android.view_model.index.IndexViewModel
import com.wsr.model.db.entities.Favorite
import core.entities.Article
import java.time.LocalDateTime

class IndexActivity : AppCompatActivity() {

    private var _binding: ActivityIndexBinding? = null
    private val binding get() = _binding!!

    private lateinit var activityIndexRecyclerView: RecyclerView
    private lateinit var indexAdapter: IndexAdapter

    private lateinit var indexViewModel: IndexViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()


        indexAdapter = IndexAdapter(this)

        val divider = DividerItemDecoration(
            this,
            LinearLayoutManager(this).orientation
        )

        activityIndexRecyclerView = binding.activityIndexRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = indexAdapter
            addItemDecoration(divider)
        }


        indexViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(IndexViewModel::class.java).apply {

            articles.observe(this@IndexActivity){
                indexAdapter.setArticles(it)
            }
        }
    }


    //お気に入りを作成する関数
    fun insertFavorite(article: Article){
        indexViewModel.insertFavorite(Favorite(
            id = 0,
            title = article.title ?: "取得エラー",
            url = article.url ?: "取得エラー",
            createdAt = LocalDateTime.now()
        ))
        Toast.makeText(this, "お気に入りに登録しました", Toast.LENGTH_LONG).show()
    }


    //Toolbarの設定
    private fun setToolbar(){
        binding.activityIndexToolBar.apply{
            setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){

                    //設定画面
                    R.id.activity_index_settings -> {
                        val intent = Intent(this@IndexActivity, SettingsActivity::class.java)
                        startActivity(intent)
                    }

                    //お気に入り一覧画面
                    R.id.activity_index_show_favorite -> {
                        val intent = Intent(this@IndexActivity, FavoriteActivity::class.java)
                        startActivity(intent)
                    }

                    //記事の再読み込み
                    R.id.activity_index_reload -> {
                        indexViewModel.reloadArticles()
                    }
                }
                true
            }
        }
    }
}
