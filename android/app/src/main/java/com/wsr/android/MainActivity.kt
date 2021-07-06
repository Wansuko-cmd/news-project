package com.wsr.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import core.repositories.CoreRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val article = CoreRepository().getArticle()
        Log.i("Article", article.toString())
    }
}
