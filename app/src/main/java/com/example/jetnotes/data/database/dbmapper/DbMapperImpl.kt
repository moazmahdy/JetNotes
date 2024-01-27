package com.example.jetnotes.data.database.dbmapper

import com.example.jetnotes.data.database.model.ColorDbModel
import com.example.jetnotes.data.database.model.NoteDbModel
import com.example.jetnotes.domain.model.ColorModel
import com.example.jetnotes.domain.model.NEW_NOTE_ID
import com.example.jetnotes.domain.model.NoteModel

class DbMapperImpl : DbMapper {

    override fun mapNotes(
        noteDbModels: List<NoteDbModel>,
        colorDbModels: Map<Long, ColorDbModel>
    ): List<NoteModel> = noteDbModels.map {
        val colorDbModel = colorDbModels[it.colorId]
            ?: throw RuntimeException("Color for colorId: ${it.colorId} was not found. Make sure that all colors are passed to this method")

        mapNote(it, colorDbModel)
    }

    override fun mapNote(noteDbModel: NoteDbModel, colorDbModel: ColorDbModel): NoteModel {
        val color = mapColor(colorDbModel)
        val isCheckedOff = with(noteDbModel) { if (canBeCheckedOff) isCheckedOff else null }
        return with(noteDbModel) { NoteModel(id, title, content, isCheckedOff, color) }
    }

    override fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel> =
        colorDbModels.map { mapColor(it) }

    override fun mapColor(colorDbModel: ColorDbModel): ColorModel =
        with(colorDbModel) { ColorModel(id, name, hex) }

    override fun mapDbNote(note: NoteModel): NoteDbModel =
        with(note) {
            val canBeCheckedOff = isCheckedOff != null
            val isCheckedOff = isCheckedOff ?: false
            if (id == NEW_NOTE_ID)
                NoteDbModel(
                    title = title,
                    content = content,
                    canBeCheckedOff = canBeCheckedOff,
                    isCheckedOff = isCheckedOff,
                    colorId = color.id,
                    isInTrash = false
                )
            else
                NoteDbModel(id, title, content, canBeCheckedOff, isCheckedOff, color.id, false)
        }

    override fun mapDbColors(colors: List<ColorModel>): List<ColorDbModel> =
        colors.map { mapDbColor(it) }

    override fun mapDbColor(color: ColorModel): ColorDbModel =
        with(color) { ColorDbModel(id, hex, name) }
}