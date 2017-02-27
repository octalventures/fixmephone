# Fix Me Phone

[![Build Status](https://travis-ci.org/techwolves/fixmephone.svg?branch=master)](https://travis-ci.org/techwolves/fixmephone)

AIO Android Bug Squasher

##### Current fixes:
* Bad ownership in /data/lib
* Bad permissions in /data/lib

____________
## How to Build/View

This tutorial will tell you how to use Eclipse to view, edit, and build Fix Me Phone.

#### Android Studio:

1. We recently changed the project to Android Studio type, the below steps can still work though.
2. Building with android studio should be quite simple, simply open the build menu and build the app there.
3. If you have the SDK but not Android Studio, the gradle files should provide a relatively simple build
4. We've added this to a CI, builds are automatically done from source there as well.

##### Prerequisites:

1. Java SE Development Kit installed
2. JDK added to your PATH var
3. Git is installed
4. Git added to your PATH var

##### Step 1: Setting up Eclipse

If you do not have Eclipse already follow version A.
If you do not have the Android SDK & Eclipse plugin, follow version B.
If you already have Eclipse and the Android SDK setup, skip this step.

###### Version A

  1. Download the Eclipse ADT from [here](https://developer.android.com/sdk/index.html)
  2. Unzip it to a directory of your choosing. Be sure it can be modified without UAC prompts, so choose something like your home directory.
  3. Under the new folder there should be a directory named 'eclipse' open it and run eclipse.exe

###### Version B

  1. Go to [the Android SDK download page](http://developer.android.com/sdk/index.html) and download and install the SDK from the 'GET THE SDK FOR AN EXISTING IDE' drop down
  2. Run the SDK manager and select a minimum of the following:
    1. `Android SDK Tools`
    2. `Android SDK Platform-tools`
    3. `Android SDK Build-tools (highest version)`
    4. `SDK Platform` (Under each of the "Android X.X" folders)
  3. Follow the instructions [here](http://developer.android.com/sdk/installing/installing-adt.html) on installing the ADT plugin.

##### Step 2: Download & import the project

1. Open a command prompt and `cd` to the directory above where you want the project downloaded to
2. Run `git clone https://github.com/techwolves/fixmephone.git folder` (replace "folder" with the folder to clone into)
3. In Eclipse, import the project using 'File > Import' selecting the project type as an "Android Project"

##### Step 3: View or modify the Java code

1. Under the 'src' directory there will be the package 'com.TWP.Project.Fixes.FS.IS' open it.
2. In there is the Java code. Double click any of them to view or modify them.

##### Step 4: View or modify the layout

1. Under the 'res/layout' directory there will be the layouts, double click to one to view or modify it.

____________
## To-do


* Add fix for insuffient storage on update
* Add fix for the Google Play "No Connection" error caused by bad permissions in /data
