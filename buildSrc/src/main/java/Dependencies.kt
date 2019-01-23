object Config {
    object Modules{
        val domain = ":domain"
        val data = ":data"
        val presentation = ":presentation"
    }

    object Versions {
        const val kotlin_version = "1.3.10"
        const val okhttp = "3.12.0"
        const val android_plugin_version = "3.2.1"
        const val support_lib = "1.0.0"
        const val retrofit = "2.4.0"
        const val rxKotlin = "2.3.0"
        const val constraint_layout = "1.1.2"
        const val junit = "4.12"
        const val junit_runner = "1.0.1"
        const val espresso_core = "3.0.1"
        const val archLifecycleVersion = "2.0.0"
        const val navigationVersion = "1.0.0-alpha07"
        const val parseVersion = "1.18.5"
        const val timber = "1.5.1"
        const val kodein = "6.0.1"
        const val rxAndroid = "2.1.0"
        const val koin = "1.0.2"
        const val circularImageView ="3.0.0"
        const val picasso ="2.71828"
        const val paperDb = "2.6"
        const val material_support="1.0.0-rc01"
    }

    object BuildPlugins {
        val android_plugin = "com.android.tools.build:gradle:${Versions.android_plugin_version}"
        val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    }

    object Android {
        val applicationId = "com.nerdsoft.kodi"
        val compileSdk = 28
        val minSdk = 18
        val targetSdk = 28
        val versionCode = 1
        val versionName = "1.0"
        val junitRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    object Libs {
        //Common dependencies
        val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin_version}"
        //android support plus other dependencies
        val support_appcompat_v7 = "androidx.appcompat:appcompat:${Versions.support_lib}"
        val material_support = "com.google.android.material:material:${Versions.material_support}"
        val recyclerview = "androidx.recyclerview:recyclerview:${Versions.support_lib}"
        val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
        val life_cycle = "androidx.lifecycle:lifecycle-extensions:${Versions.archLifecycleVersion}"
        val view_model = "androidx.lifecycle:lifecycle-viewmodel:${Versions.archLifecycleVersion}"
        val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
        val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
        val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
        val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
        val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
        val nav_fragment= "android.arch.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
        val nav_ui = "android.arch.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
        val parse_sdk = "com.github.parse-community.Parse-SDK-Android:ktx:${Versions.parseVersion}"
        val timber_ktx = "com.github.ajalt:timberkt:${Versions.timber}"
        val circular_image_view = "de.hdodenhof:circleimageview:${Versions.circularImageView}"
        val okhttp_logger = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        val paper_db = "io.paperdb:paperdb:${Versions.paperDb}"
        //Libs for dependency injection
        val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"
        val kodein_androidx = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"
        val koin_core = "org.koin:koin-core:${Versions.koin}"
        val koin_android = "org.koin:koin-android:${Versions.koin}"
        val koin_scoping = "org.koin:koin-androidx-scope:${Versions.koin}"
        val koin_viewmodel ="org.koin:koin-androidx-viewmodel:${Versions.koin}"
        val koin_test = "org.koin:koin-test:${Versions.koin}"
        //test dependencies
        val junit = "junit:junit:${Versions.junit}"
        val junit_runner = "com.android.support.test:runner:${Versions.junit_runner}"
        val espresso_core =
            "com.android.support.test.espresso:espresso-core:${Versions.espresso_core}"


    }
}
