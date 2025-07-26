package com.app.noteapp.feature_note.domain.use_case

import com.app.noteapp.feature_note.domain.model.Note
import com.app.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repo: NoteRepository
) {

    suspend fun invoke(note: Note) {
        repo.deleteNote(note = note)
    }

}