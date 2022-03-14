package com.media.populus.web

import android.content.Context
import android.webkit.JavascriptInterface

class SampleWebAppInterface(private val mContext: Context): PopulusWebInterface {

    /**
     * This method will be called from javascript
     * event values are
     *  init
     *  noAds
     *  error
     */
    @JavascriptInterface
    override fun handleEvent(event: String) {
        println("Javascript event: $event")
        if(event!=null && (JavascriptEvent.NO_ADS.name.equals(event)
                    || JavascriptEvent.ERROR.name.equals(event)) ) {
            hideWebView()
        }
    }

    private fun hideWebView() {
//        (mContext as MainActivity).runOnUiThread(Runnable {
//            val webView: WebView = (mContext as MainActivity).webView!!
//            //findViewById<WebView>(R.id.web_View)
//            println("###### Hiding a web view #### : ")
//            webView.setVisibility(View.GONE);
//        })
    }
}