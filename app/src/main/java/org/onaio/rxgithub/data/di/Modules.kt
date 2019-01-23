package org.onaio.rxgithub.data.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import org.onaio.rxgithub.data.datastore.remote.GithubApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object Modules {

    object KoinProperties {
       const val BASE_URL ="BASE_URL"
    }

    private val networkModules = module {
        single { provideOkHttpClient() }
        single { createApiService<GithubApiService>(get(), getProperty(KoinProperties.BASE_URL)) }
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private inline fun <reified T> createApiService(okHttpClient: OkHttpClient, baseUrl: String): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(T::class.java)
    }

    val dataModules = listOf(networkModules)
}