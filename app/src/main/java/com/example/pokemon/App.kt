package com.example.pokemon

import android.app.Application
import com.example.pokemon.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    fun OnCreate() {
        super.onCreate()
    }

    private fun configureDI() = startKoin {
        androidContext(this@App)
        modules(appComponent)
    }
}