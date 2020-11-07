package com.journaler.api.repository

import com.journaler.api.data.Note
import org.springframework.data.repository.CrudRepository

/**
 * Identyfikator notatki jest typu String.
 */
interface NoteRepository : CrudRepository<Note, String> {
  fun findByTitle(title: String): Iterable<Note>
}