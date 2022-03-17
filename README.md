# popcorn-anadroid
## Android library to Integrate with [Populue media](https://populusmedia.github.io/docs/)

### Usage:
Add below section to your build.gradle file
```
       maven {
            url uri("https://maven.pkg.github.com/populusmedia/popcorn-android")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
```

Add a dependency to you android app's build.gradle file
```
    implementation 'com.media.populus:populus-android:0.2.0'

```
