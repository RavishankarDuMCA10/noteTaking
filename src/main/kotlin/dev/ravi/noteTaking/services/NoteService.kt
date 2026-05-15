package dev.ravi.noteTaking.services

import dev.ravi.noteTaking.dataSources.NoteRepository
import dev.ravi.noteTaking.model.Note
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val repository: NoteRepository
) {

    fun getNotes(): List<Note> {
        return repository.getNotes()
    }

    fun deleteNote(noteId: String) {
        repository.deleteNotes(noteId)
    }

    fun createNote(note: Note): Note {
        return repository.addNote(note)
    }

    fun patchNote(note: Note): Note {
        return repository.patchNote(note)
    }
}