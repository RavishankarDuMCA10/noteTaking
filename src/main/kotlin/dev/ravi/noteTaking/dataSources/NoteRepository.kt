package dev.ravi.noteTaking.dataSources

import dev.ravi.noteTaking.model.Note
import org.springframework.stereotype.Repository

@Repository
class NoteRepository {

    val mockNotes = mutableListOf<Note>(
        Note(
            title = "Note Title",
            description = "Note Description",
        ),
    )

    fun getNotes() = mockNotes

    fun deleteNotes(noteId: String) {
        val tempNote = mockNotes.firstOrNull{ it.id == noteId }
        if (tempNote != null) {
            mockNotes.remove(tempNote)
        } else {
            throw NoSuchElementException("No note found")
        }
    }

    fun addNote(note: Note): Note {
        val tempNote = mockNotes.firstOrNull{ it.id == note.id }
        if (tempNote == null) {
            mockNotes.add(note)
            return note
        } else {
            throw IllegalArgumentException("Cannot add note ${note.id}")
        }
    }

    fun patchNote(note: Note): Note {
        val tempNote = mockNotes.firstOrNull{ it.id == note.id }
        if (tempNote != null) {
            mockNotes.remove(tempNote)
            mockNotes.add(note)
            return note
        } else {
            throw NoSuchElementException("No note found for ID ${note.id}")
        }
    }
}