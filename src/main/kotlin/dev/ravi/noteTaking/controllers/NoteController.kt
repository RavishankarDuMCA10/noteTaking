package dev.ravi.noteTaking.controllers

import dev.ravi.noteTaking.model.Note
import dev.ravi.noteTaking.services.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notes")
class NoteController(
    private val service: NoteService
) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(e: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

    @GetMapping
    fun getNotes(): List<Note> {
        return service.getNotes()
    }

    @DeleteMapping("/{noteId}")
    fun deleteNotes(@PathVariable("noteId") noteId: String) {
        service.deleteNote(noteId)
    }

    @PostMapping
    fun createNote(@RequestBody note: Note): Note {
        return service.createNote(note)
    }

    @PatchMapping
    fun patchNote(@RequestBody note: Note): Note {
        return service.patchNote(note)
    }
}