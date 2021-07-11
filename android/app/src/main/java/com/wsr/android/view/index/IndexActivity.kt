package com.wsr.android.view.index

import android.content.Intent
import android.os.Bundle
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
            ViewModelProvider.NewInstanceFactory()
        ).get(IndexViewModel::class.java).apply {

            articles.observe(this@IndexActivity){
                indexAdapter.setArticles(it)
            }
        }
    }


    private fun setToolbar(){
        binding.activityIndexToolBar.apply{
            setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.settings -> {
                        val intent = Intent(this@IndexActivity, SettingsActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.favorite -> {
                        val intent = Intent(this@IndexActivity, FavoriteActivity::class.java)
                        startActivity(intent)
                    }
                }

                true
            }
        }
    }
}
