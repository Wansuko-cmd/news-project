package com.wsr.android.view.show

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient

class ShowWebViewClient(
    private val setTitle: (String) -> Unit = {}
) : WebViewClient() {

    //記事のタイトルをToolbarに設定（URL）
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)

        setTitle(view?.title ?: "")
    }

    //記事のタイトルをToolbarに設定（タイトル）
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        setTitle(view?.title ?: "")
    }
}
