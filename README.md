# Clone App Detection
[![Release](https://jitpack.io/v/abidjamil/CloneAppDetection.svg)](https://jitpack.io/#abidjamil/CloneAppDetection)
[![GitHub release](https://img.shields.io/github/release/abidjamil/CloneAppDetection.svg)](https://GitHub.com/abidjamil/CloneAppDetection/releases/)
[![Github all releases](https://img.shields.io/github/downloads/abidjamil/CloneAppDetection/total.svg)](https://GitHub.com/abidjamil/CloneAppDetection/releases/)

Clone Apps can create false crashes and exceptions due to its architecture and implementation. This library will help developers to detect clone apps.
```
If you love this boilerplate, give us a star, you will be a ray of sunshine in our lives :)
```


**This library will detect following type of clones**
```kotlin
enum class CloneType {
        OEM, SecondSpace, ThirdParty,
    }
```
- [x] **OEM** : App clones through OS DUAL APP Features.
- [x] **SecondSpace** : App clones through second space & multiple users feature.
- [x] **ThirdParty** : App clones through third party cloning apps.


## Updates

The library will follow new releases as soon as new techniques introduced.


## Using the library
For a working implementation, please have a look at the Sample Project

### 1- Include the library
To use this library in project to detect clone:

Add it to your build.gradle with:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and:

```gradle
dependencies {
    compile 'com.github.jitpack:android-example:{latest version}'
}
```


### 2- Calling Methods
```kotlin
    val cloneDetection = CloneDetection(this, packageName);
    val isClone = cloneDetection.checkAppCloning();
    val cloneDetails = cloneDetection.getCloneDetails()
    
```

## License

This project is released under the [MIT License](LICENSE).

## Contributions 
Contributions, issues and feature requests are welcome.
Feel free to check [issues](https://github.com/abidjamil/CloneAppDetection/issues "issues") page if you want to contribute.

## About Me

<h1 align="center">Hi 👋, I'm Abid Jamil</h1>
<h3 align="center">🧑🏽‍💻Technical Lead @ GrocerApp </h3>
<p align="center">
	<a href="https://www.linkedin.com/in/abidjamil"><img src="https://img.shields.io/badge/LinkedIn--_.svg?style=social&logo=linkedin" alt="LinkedIn"></a>  
  <a href="https://github.com/abidjamil"><img src="https://img.shields.io/github/followers/wajahatkarim3.svg?label=GitHub&style=social" alt="GitHub"></a>  
</p>
<h6>💻 Open source contriubtion </h6>
<h6>📝 Author of 18 research articles.</h6>
<h6>🎤 Actively working on community building through public speaking at different national and international venues.</h6>


<p align="left"> <img src="https://komarev.com/ghpvc/?username=abidjamil&label=Profile%20views&color=0e75b6&style=flat" alt="abidjamil" /> </p>

<p align="left"> <a href="https://github.com/ryo-ma/github-profile-trophy"><img src="https://github-profile-trophy.vercel.app/?username=abidjamil" alt="abidjamil" /></a> </p>

<p align="left"> <a href="https://twitter.com/chabidgill" target="blank"><img src="https://img.shields.io/twitter/follow/chabidgill?logo=twitter&style=for-the-badge" alt="chabidgill" /></a> </p>
