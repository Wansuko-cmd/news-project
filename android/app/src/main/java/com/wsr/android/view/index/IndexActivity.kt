package com.wsr.android.view.index

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsr.android.R
import com.wsr.android.databinding.ActivityIndexBinding

class IndexActivity : AppCompatActivity() {

    private var _binding: ActivityIndexBinding? = null
    private val binding get() = _binding!!

    private lateinit var activityIndexRecyclerView: RecyclerView
    private lateinit var indexAdapter: IndexAdapter

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
    }
}
