package com.journaler.api.repository

import com.journaler.api.data.Todo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Identyfikator zadania jest typu String.
 */
interface TodoRepository : CrudRepository<Todo, String> {

  @Query("FROM Todo WHERE schedule > ?1")
  fun findScheduledLaterThan(date: Long): Iterable<Todo>

}