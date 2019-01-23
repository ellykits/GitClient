import Config.Android.applicationId
import Config.Android.compileSdk
import Config.Android.minSdk
import Config.Android.targetSdk
import Config.Android.versionCode
import Config.Android.versionName

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}
android {String
    compileSdkVersion(compileSdk)
    defaultConfig {
        minSdkVersion(minSdk)
        targetSdkVersion(targetSdk)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName
        testInstrumentationRunner = Config.Android.junitRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
}


dependencies {
    //Presentation dependencies
    implementation(Config.Libs.kotlin_stdlib)
    implementation(Config.Libs.support_appcompat_v7)
    implementation(Config.Libs.material_support)
    implementation(Config.Libs.constraint_layout)
    implementation(Config.Libs.recyclerview)
    implementation(Config.Libs.life_cycle)
    implementation(Config.Libs.view_model)
    implementation(Config.Libs.timber_ktx)
    implementation(Config.Libs.koin_android)
    implementation(Config.Libs.koin_scoping)
    implementation(Config.Libs.koin_viewmodel)
    implementation(Config.Libs.rxkotlin)
    implementation(Config.Libs.rxandroid)
    implementation(Config.Libs.circular_image_view)
    implementation(Config.Libs.picasso)

    //Data dependencies
    implementation(Config.Libs.retrofit)
    implementation(Config.Libs.retrofit_rxjava_adapter)
    implementation(Config.Libs.moshi_converter)
    implementation(Config.Libs.okhttp_logger)
    implementation(Config.Libs.paper_db)

    testImplementation(Config.Libs.junit)
    androidTestImplementation(Config.Libs.junit_runner)
    androidTestImplementation(Config.Libs.espresso_core)
}
