package com.app.noteapp.feature_note.presentation.add_edit_notes

data class NoteTextFieldState (
    val text : String = "",
    val hint : String = "",
    val isHintVisible: Boolean = true
)