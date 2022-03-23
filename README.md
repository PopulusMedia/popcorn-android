
### Android library to integrate with [Populus Media](https://populusmedia.github.io/docs/index.html).

1. Include the following repository in your build.gradle file. (Also, check settings.gradle to see if you have dependencyResolutionManagement, and add it if necessary.)
_[To obtain GITHUB ACTOR and GITHUB TOKEN, please contact Populus Media.]_

```
maven {
            url uri("https://maven.pkg.github.com/populusmedia/popcorn-android")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }           
        }
```

2. Add a Populus media library dependency to the `dependencies {` section of build.gradle
   e.g  
`         implementation 'com.media.populus:populus-android:<version>' ` 
  Please use the most recent version.

3. Set GITHUB_ACTOR and GITHUB_TOKEN environment variables before starting a gradle build process.

 
4. To display ads, the Populus Android library requires a **web view.**
    Create a web view component
e.g.
```
<WebView
        android:id="@+id/web_View"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:layout_constraintBottom_toBottomOf="@+id/clock" />
```

6. Add an addJavascriptInterface to a webView with the name "**Android**." No other name should be used as this is referred to in a javascript library.
This is necessary in order to handle javascript events.
    For example, to hide a web view if there are no ads or if there is an error.
```
        webView = findViewById(R.id.web_View)
        webView?.addJavascriptInterface(SampleWebAppInterface(this), "Android")
```
SampleWebAppInterface is a sample web interface to demonstrate event handling.

You must implement the `com.media.populus.web.PopulusWebInterface` interface and _override_ the **handleEvent**(event: String) method to create a similar class.
**Also, keep in mind that you must annotate a handleEvent method with the `@JavascriptInterface` annotation.**

7. Using `PopulusMedia.Builder()`, create an instance of the `PopulusMedia` class and pass the required parameters. 
     e.g. 
      ```  
        val pm = PopulusMedia.Builder()
            .network("thm")
            .partner("test")
            .visitId(UUID.randomUUID().toString())
            //.visitId("1234")
            .width("800")
            .height("400")
            .keywords("lupus")
            .build()
    ```  
     where
          - partner is the partner-code (provided by Populus Media)
          - visitId is the visit-id associated with the visit
          - width is the maximum width of external content from Populus Media
          - height is the maximum height external content from Populus Media 
          - keywords are the keywords associated with the session/visit
       For a complete list of attributes that could be passed, please refer the [home page](https://populusmedia.github.io/docs/index.html).

8. Pass a **web view** created earlier to the `configureWebView` method.
   e.g.         
   `pm.configureWebView(webView)`
         This will configure the web view URL, settings and webChromeClient
