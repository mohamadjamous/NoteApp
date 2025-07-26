package com.app.noteapp.di

import android.app.Application
import androidx.room.Room
import com.app.noteapp.feature_note.data.data_source.NoteDatabase
import com.app.noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.app.noteapp.feature_note.domain.repository.NoteRepository
import com.app.noteapp.feature_note.domain.use_case.DeleteNoteUseCase
import com.app.noteapp.feature_note.domain.use_case.GetNotesUseCase
import com.app.noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun providesNoteRepository(db : NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    fun provideNoteUseCase(repo: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repo),
            deleteNote = DeleteNoteUseCase(repo)
        )
    }
}