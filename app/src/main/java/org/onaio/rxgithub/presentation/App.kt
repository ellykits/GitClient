package org.onaio.rxgithub.presentation

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.onaio.rxgithub.data.di.Modules.dataModules
import org.onaio.rxgithub.presentation.di.Modules.presentationModules
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        initKoin()
    }

    private fun initKoin() {
        startKoin(this, presentationModules + dataModules, loadPropertiesFromFile = true)
    }
}