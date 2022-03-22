package com.media.populus.web

import android.webkit.*


class PopulusMedia  private constructor (
    val network: String?,
    val partner: String?,
    val partnerSubAcct: String?,
    val visitId: String?,
    val anonId: String?,
    val suppress: String?,
    val width: String?,
    val height: String?,
    val aspectRatio: String?,
    val visitStage: String?,
    val inventoryClass: String?,
    val reason: String?,
    val keywords: String?,
    val icdx: String?
) {
    val caller: String? = "android"
    val BASE_URL = "https://cdn.populus-media.net"

    data class Builder(
        var network: String? = null,
        var partner: String? = null,
        var partnerSubAcct: String? = null,
        var visitId: String? = null,
        var anonId: String? = null,
        var suppress: String? = null,
        var width: String? = null,
        var height: String? = null,
        var aspectRatio: String? = null,
        var visitStage: String? = null,
        var inventoryClass: String? = null,
        var reason: String? = null,
        var keywords: String? = null,
        var icdx: String? = null
    ) {

        fun network(network: String) = apply { this.network = network }
        fun partner(partner: String) = apply { this.partner = partner }
        fun partnerSubAcct(partnerSubAcct: String) = apply { this.partnerSubAcct = partnerSubAcct }
        fun visitId(visitId: String) = apply { this.visitId = visitId }
        fun anonId(anonId: String) = apply { this.anonId = anonId }
        fun suppress(suppress: String) = apply { this.suppress = suppress }
        fun width(width: String) = apply { this.width = width }
        fun height(height: String) = apply { this.height = height }
        fun aspectRatio(aspectRatio: String) = apply { this.aspectRatio = aspectRatio }
        fun visitStage(visitStage: String) = apply { this.visitStage = visitStage }
        fun inventoryClass(inventoryClass: String) = apply { this.inventoryClass = inventoryClass }
        fun reason(reason: String) = apply { this.reason = reason }
        fun keywords(keywords: String) = apply { this.keywords = keywords }
        fun icdx(icdx: String) = apply { this.icdx = icdx }

        fun build() = PopulusMedia(network, partner, partnerSubAcct, visitId, anonId, suppress, width, height, aspectRatio, visitStage, inventoryClass, reason, keywords, icdx)
    }

    public fun configureWebView(webView: WebView?) {
        if(webView!=null) {
            webView.webChromeClient = WebChromeClient()
            val webSettings: WebSettings = webView.getSettings()
            webSettings.javaScriptEnabled = true

            val url = BASE_URL+"/popcorn/v4/embed.html?" + getQueryParamsString()
            val dataHtml = "<iframe src=\""+ url+ "\"></iframe>"
            println(dataHtml)
            webView.loadDataWithBaseURL(
                BASE_URL,
                dataHtml,
                "text/html",
                "UTF-8",
                null
            );
        }
    }

    private fun getQueryParamsString(): String {
        val queryParams = StringBuilder()
        if(this.caller != null) {
            queryParams.append("caller").append("=").append(this.caller).append("&")
        }
        if(this.network != null) {
            queryParams.append("network").append("=").append(this.network).append("&")
        }
        if(this.partner != null) {
            queryParams.append("partner").append("=").append(this.partner).append("&")
        }
        if(this.partnerSubAcct != null) {
            queryParams.append("partner-subacct").append("=").append(this.partnerSubAcct).append("&")
        }
        if(this.visitId != null) {
            queryParams.append("visit-id").append("=").append(this.visitId).append("&")
        }
        if(this.anonId != null) {
            queryParams.append("anon-id").append("=").append(this.anonId).append("&")
        }
        if(this.suppress != null) {
            queryParams.append("suppress").append("=").append(this.suppress).append("&")
        }
        if(this.width != null) {
            queryParams.append("width").append("=").append(this.width).append("&")
        }
        if(this.height != null) {
            queryParams.append("height").append("=").append(this.height).append("&")
        }
        if(this.aspectRatio != null) {
            queryParams.append("aspect-ratio").append("=").append(this.aspectRatio).append("&")
        }
        if(this.visitStage != null) {
            queryParams.append("visit-stage").append("=").append(this.visitStage).append("&")
        }
        if(this.inventoryClass != null) {
            queryParams.append("inventory-class").append("=").append(this.inventoryClass).append("&")
        }
        if(this.reason != null) {
            queryParams.append("reason").append("=").append(this.reason).append("&")
        }
        if(this.keywords != null) {
            queryParams.append("keywords").append("=").append(this.keywords).append("&")
        }
        if(this.icdx != null) {
            queryParams.append("icdx").append("=").append(this.icdx).append("&")
        }

        var result: String= queryParams.toString()
        if(result.isNotEmpty() && result[result.length-1] == '&') {
            result = result.dropLast(1)
        }

        return result
    }

}