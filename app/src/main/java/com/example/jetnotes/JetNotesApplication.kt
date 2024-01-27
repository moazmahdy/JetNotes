package com.example.jetnotes

import android.app.Application
import com.example.jetnotes.di.DependencyInjector

class JetNotesApplication : Application() {

    lateinit var dependencyInjector: DependencyInjector

    override fun onCreate() {
        super.onCreate()
        initDependencyInjector()
    }

    private fun initDependencyInjector() {
        dependencyInjector = DependencyInjector(this)
    }
}