package com.wsr.android.view.index

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.databinding.ActivityIndexBinding
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

        indexAdapter = IndexAdapter()

        activityIndexRecyclerView = binding.activityIndexRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = indexAdapter
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
}
