package com.media.populus.web

enum class JavascriptEvent(val event: String) {
    ERROR("error"),
    NO_ADS("noAds"),
    INIT("init"),
    RENDERED("rendered"),
    VIEWED("viewed"),
    DONE("done")
}