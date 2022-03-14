package com.media.populus;

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.media.populus.web.PopulusMedia
import com.media.populus.web.SampleWebAppInterface
import java.util.*

class MainActivity : AppCompatActivity() {
    var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWebView()
    }

    private fun setupWebView() {
        webView = findViewById(R.id.web_View)
        this.webView

        webView?.addJavascriptInterface(SampleWebAppInterface(this), "Android")

        val pm = PopulusMedia.Builder()
            .network("thm")
            .partner("test")
            .visitId(UUID.randomUUID().toString())
            //.visitId("1234")
            .width("800")
            .height("400")
            .keywords("lupus")
            .build()

        pm.configureWebView(webView)
    }

}