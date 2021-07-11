package com.wsr.android.view.show

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wsr.android.R
import com.wsr.android.databinding.ActivityShowBinding
import com.wsr.android.view_model.show.ShowViewModel
import core.entities.Article

class ShowActivity : AppCompatActivity() {

    private var _binding: ActivityShowBinding? = null
    private val binding get() = _binding!!

    private lateinit var showViewModel: ShowViewModel

    private lateinit var showWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ShowViewModel::class.java)

        setToolbar()

        intent.getStringExtra("url")?.let{
            showWebView = binding.activityShowWebView.apply{
                loadUrl(it)
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
            }
        }
    }

    private fun setToolbar(){
        binding.activityShowToolBar.also{

            it.setOnMenuItemClickListener { menuItem ->

                when(menuItem.itemId){
                    R.id.activity_show_register_favorite -> {

                        val article = Article(
                            title = showWebView.title,
                            url = showWebView.url
                        )
                        showViewModel.createFavorite(article)

                        Toast.makeText(this, "お気に入りに登録しました", Toast.LENGTH_LONG).show()
                    }
                }

                true
            }
        }
    }
}
