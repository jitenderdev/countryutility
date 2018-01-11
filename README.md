
# Beautiful Country Utility for Android


Countryutility is a simple library that enables you to pick a country while signing up or get the details of a country i.e Name, Flad, ISO Code and ISD code.

See the example to see more detail.

![](https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/1.jpg)
![](https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/2.jpg)
![](https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/3.jpg)
![](https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/4.jpg)

## How to use

### Integration

Integrating the project is simple a refined all you need to do is follow the below steps

Step 1\. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```

Step 2\. Add the dependency

```java
dependencies {
        compile 'com.github.jitenderdev:countryutility:v1.0'
}
