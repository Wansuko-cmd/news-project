package com.wsr.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import core.repositories.CoreRepository
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            val coreRepository = CoreRepository()
            val article = coreRepository.getArticle()
            Log.i("Article", article.toString())
        }
    }
}
