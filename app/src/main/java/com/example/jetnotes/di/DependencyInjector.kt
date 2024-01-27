package com.example.jetnotes.di

import android.content.Context
import androidx.room.Room
import com.example.jetnotes.data.database.AppDatabase
import com.example.jetnotes.data.database.dbmapper.DbMapper
import com.example.jetnotes.data.database.dbmapper.DbMapperImpl
import com.example.jetnotes.data.repo.Repo
import com.example.jetnotes.data.repo.RepoImpl

class DependencyInjector(applicationContext: Context) {

    val repository: Repo by lazy { provideRepository(database) }

    private val database: AppDatabase by lazy { provideDatabase(applicationContext) }

    private val dbMapper: DbMapper = DbMapperImpl()

    private fun provideDatabase(applicationContext: Context): AppDatabase =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()

    private fun provideRepository(database: AppDatabase): Repo {
        val noteDao = database.noteDao()
        val colorDao = database.colorDao()

        return RepoImpl(noteDao, colorDao, dbMapper)
    }
}