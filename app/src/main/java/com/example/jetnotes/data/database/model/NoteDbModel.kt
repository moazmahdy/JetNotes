package com.example.jetnotes.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "can_be_checked_off") val canBeCheckedOff: Boolean,
    @ColumnInfo(name = "is_checked_off") val isCheckedOff: Boolean,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean
) {

    companion object {

        val DEFAULT_NOTES = listOf(
            NoteDbModel(1, "Kodeco Meeting", "Prepare sample project", false, false, 1, false),
            NoteDbModel(2, "Bills", "Pay by tomorrow", false, false, 2, false),
            NoteDbModel(3, "Pancake recipe", "Milk, eggs, salt, flour...", false, false, 3, false),
            NoteDbModel(4, "Workout", "Running, push ups, pull ups, squats...", false, false, 4, false),
            NoteDbModel(5, "Title 5", "Content 5", false, false, 5, false),
            NoteDbModel(6, "Title 6", "Content 6", false, false, 6, false),
            NoteDbModel(7, "Title 7", "Content 7", false, false, 7, false),
            NoteDbModel(8, "Title 8", "Content 8", false, false, 8, false),
            NoteDbModel(9, "Title 9", "Content 9", false, false, 9, false),
            NoteDbModel(10, "Title 10", "Content 10", false, false, 10, false),
            NoteDbModel(11, "Title 11", "Content 11", true, false, 11, false),
            NoteDbModel(12, "Title 12", "Content 12", true, false, 12, false)
        )
    }
}