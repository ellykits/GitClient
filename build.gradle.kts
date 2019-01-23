// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Config.BuildPlugins.android_plugin)
        classpath (Config.BuildPlugins.kotlin_plugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven ( url ="https://jitpack.io" )

    }
}
task("clean") {
    delete(rootProject.buildDir)
}