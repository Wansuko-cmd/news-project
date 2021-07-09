package com.wsr.android.view.show

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.wsr.android.databinding.ActivityShowBinding

class ShowActivity : AppCompatActivity() {

    private var _binding: ActivityShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("url")?.let{
            binding.activityShowWebView.apply{
                loadUrl(it)
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
            }
        }
    }
}
