package com.blink.dagger.bighead.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.blink.dagger.bighead.R
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.activity_web_view.*
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bumptech.glide.Glide


class WebViewActivity : AppCompatActivity() {

    //网页地址
    var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

//        Glide.with(this).load(R.drawable.loadding).into(loadingImg)

        initView()
    }

    private fun initView() {
        //启用支持javascript
        val settings = mWebView.getSettings()
        //缩放至屏幕大小
        settings.setLoadWithOverviewMode(true)
        //将图片调整到webview大小
        settings.setUseWideViewPort(true)
        //可以显示JavaScript形式
        settings.setJavaScriptEnabled(true)
        //对于有些html做了设置的不能进行缩放
        settings.setSupportZoom(true)
        //        //设置webview的字号为大
        //        settings.setTextSize(WebSettings.TextSize.NORMAL);
        // 设置出现缩放工具
        settings.setBuiltInZoomControls(true)
        //        //没有网络的情况下打开以前缓存的网页
        //        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //支持获取手势焦点
        mWebView.requestFocusFromTouch()

        url = intent.getStringExtra("url")
        url.let {
            mWebView.loadUrl(url)
        }
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        mWebView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        })

        mWebView.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                if (newProgress == 100) {
                    // 网页加载完成
                    mWebView.visibility = View.VISIBLE

                } else {
                    // 加载中
                    mWebView.visibility = View.GONE
                }
            }
        })
    }
}
