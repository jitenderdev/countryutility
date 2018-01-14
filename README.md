
# Country Utility 


> Does your application **needs user's country information**? Do you want to have information of all countries **up and running in less than 5 minutes**? Do you want to pick user's **ISO Code**?
Do you want to pick user's **ISD Code**? Do you want to have user's **Flag of Country**?

If any (or all) of these questions seem familiar, the **Country Utility** is the perfect library for you all.

**Never** waste your time again string all countries information in yoor database.
It provides you with the available countries across the globe with thier basic information required while signup with your application. Customizations are also available w.r.t. your application theme. It provide **custom colors**, **custom themes**, ... **No limits** for customizations.

### A quick overview of what's in it 
- **the easiest possible integration**
- integrate in less than **5 minutes**
- compatible down to **API Level 15**
- get you **Database of all Countries**
- get you the **Country Flag**
- get you the **Country ISO Code**
- get you the **Country ISD Code**


# Beautiful Country Utility for Android


Countryutility is a simple library that enables you to pick a country while signing up or get the details of a country i.e Name, Flad, ISO Code and ISD code.

See the example to see more detail.

<table align="center">
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/1.png" height="400" height="500"/>
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/2.png" height="400" height="500" />
        </td>
          <tr>
         <td>
            <img src="https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/3.png" height="400" height="500" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/jitenderdev/countryutility/master/screenshots/4.png" height="400" height="500" />
        </td>
          </tr>
      </tr>
</table>


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
        compile 'com.github.jitenderdev:countryutility:v1.1'
}


Step 3\. Customize your theme. Add below colors in your colors.xml

   <!-- Country Util -->
    <color name="countryColorPrimary">#0FBA0A</color>
    <color name="countryColorPrimaryDark">#41890B</color>
    <color name="countryColorAccent">#0B1A89</color>

