package com.app.noteapp.feature_note.domain.use_case

import com.app.noteapp.feature_note.domain.model.InvalidNotesException
import com.app.noteapp.feature_note.domain.model.Note
import com.app.noteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repo: NoteRepository
) {

    @Throws(InvalidNotesException::class)
    suspend operator fun invoke(note: Note){

        if (note.title.isBlank()){
            throw InvalidNotesException("The title of the note can't be empty")
        }

        if (note.content.isBlank()){
            throw InvalidNotesException("The content of the note can't be empty")
        }


        repo.insertNote(note)
    }
}