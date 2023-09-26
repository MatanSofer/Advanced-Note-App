package com.example.advancednoteapplicaion.feature_note.domain.use_case

import com.example.advancednoteapplicaion.feature_note.domain.model.InvalidNoteException
import com.example.advancednoteapplicaion.feature_note.domain.model.Note
import com.example.advancednoteapplicaion.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("title cant be empty")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("content cant be empty")
        }
        repository.insertNote(note)
    }
}