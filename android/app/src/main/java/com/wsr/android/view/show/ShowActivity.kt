package com.wsr.android.view.show

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    private lateinit var showWebViewClient: ShowWebViewClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ShowViewModel::class.java)

        showWebViewClient = ShowWebViewClient{
            binding.activityShowToolBar.title = it
        }

        intent.getStringExtra("url")?.let{
            showWebView = binding.activityShowWebView.apply{
                loadUrl(it)
                settings.javaScriptEnabled = true
                webViewClient = showWebViewClient
            }

            setToolbar()
        }

        binding.apply {
            activityShowGoBack.setOnClickListener {
                showWebView.goBack()
            }

            activityShowRepeat.setOnClickListener {
                showWebView.reload()
            }

            activityShowGoForward.setOnClickListener {
                showWebView.goForward()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && showWebView.canGoBack()) {
            showWebView.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
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

                    R.id.activity_show_share -> {
                        //ユーザの指定したアプリへのintentの処理
                        val intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, showWebView.url)
                        }
                        startActivity(intent)
                    }

                    R.id.activity_show_use_browser -> {
                        val webpage = Uri.parse(showWebView.url)
                        val intent = Intent(Intent.ACTION_VIEW, webpage)
                        startActivity(intent)
                    }
                }

                true
            }

            it.setOnClickListener {
                AlertDialog.Builder(this)
                    .setTitle("確認")
                    .setMessage("ホームに戻りますか？")
                    .setPositiveButton("はい"){_, _ ->
                        finish()
                    }
                    .setNegativeButton("いいえ", null)
                    .show()
            }
        }
    }
}
