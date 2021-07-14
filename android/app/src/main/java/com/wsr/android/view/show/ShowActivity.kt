package com.wsr.android.view.show

import android.annotation.SuppressLint
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
import com.wsr.android.view.settings.checkUseJS
import com.wsr.android.view_model.show.ShowViewModel
import com.wsr.model.db.entities.Favorite
import java.time.LocalDateTime

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
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(ShowViewModel::class.java)


        showWebViewClient = ShowWebViewClient{
            binding.activityShowToolBar.title = it
        }

        //渡されたURLがnullじゃない場合
        intent.getStringExtra("url")?.let{

            //記事の読み込み
            showWebView = binding.activityShowWebView.apply{
                loadUrl(it)
                webViewClient = showWebViewClient

                @SuppressLint("SetJavaScriptEnabled")
                if(checkUseJS(this@ShowActivity)) settings.javaScriptEnabled = true
            }

            setToolbar()
        }


        //各種操作ボタンの設定
        binding.apply {
            activityShowGoBack.setOnClickListener {
                showWebView.goBack()
            }

            activityShowReload.setOnClickListener {
                showWebView.reload()
            }

            activityShowGoForward.setOnClickListener {
                showWebView.goForward()
            }
        }
    }


    //戻るボタンの設定
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK && showWebView.canGoBack()) {
            showWebView.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }


    //Toolbarの設定
    private fun setToolbar(){
        binding.activityShowToolBar.apply{

            setOnMenuItemClickListener { menuItem ->

                when(menuItem.itemId){

                    //お気に入りに登録する機能
                    R.id.activity_show_register_favorite -> {

                        val favorite = Favorite(
                            id = 0,
                            title = showWebView.title ?: "取得エラー",
                            url = showWebView.url ?: "取得エラー",
                            createdAt = LocalDateTime.now()
                        )
                        showViewModel.insertFavorite(favorite)

                        Toast.makeText(this@ShowActivity, "お気に入りに登録しました", Toast.LENGTH_LONG).show()
                    }


                    //共有機能
                    R.id.activity_show_share -> {
                        //ユーザの指定したアプリへのintentの処理
                        val intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, showWebView.url)
                        }
                        startActivity(intent)
                    }


                    //ブラウザで開く機能
                    R.id.activity_show_use_browser -> {
                        val webpage = Uri.parse(showWebView.url)
                        val intent = Intent(Intent.ACTION_VIEW, webpage)
                        startActivity(intent)
                    }
                }

                true
            }

            //タイトルを押したときの処理
            setOnClickListener {
                AlertDialog.Builder(this@ShowActivity)
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
