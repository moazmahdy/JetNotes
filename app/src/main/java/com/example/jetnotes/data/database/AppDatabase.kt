package com.example.jetnotes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetnotes.data.database.dao.ColorDao
import com.example.jetnotes.data.database.dao.NoteDao
import com.example.jetnotes.data.database.model.ColorDbModel
import com.example.jetnotes.data.database.model.NoteDbModel

@Database(entities = [NoteDbModel::class, ColorDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "note-maker-database"
    }

    abstract fun noteDao(): NoteDao

    abstract fun colorDao(): ColorDao
}