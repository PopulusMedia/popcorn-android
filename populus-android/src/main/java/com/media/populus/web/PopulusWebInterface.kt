package com.media.populus.web

import android.webkit.JavascriptInterface

interface PopulusWebInterface {

    @JavascriptInterface
    fun handleEvent(event: String)
}