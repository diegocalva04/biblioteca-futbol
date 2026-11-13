package com.example.bibliotecafutbol

import android.app.Application
import com.example.bibliotecafutbol.data.AppContainer
import com.example.bibliotecafutbol.data.DefaultAppContainer

class BibliotecaFutbolApplication : Application() {
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
