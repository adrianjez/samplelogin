package com.journaler.api.data

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "note")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedQuery(
  name = "Note.findByTitle",
  query = "SELECT n FROM Note n WHERE title LIKE ?1"
)
data class Note(
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "varchar(36)")
  var id: String = "",
  var title: String,
  var message: String,
  var location: String = "",
  @CreationTimestamp
  var created: Date = Date(),
  @UpdateTimestamp
  var modified: Date = Date()
) {

  /**
   * Platforma Hibernate tworzy obiekt, wykorzystując refleksję.
   * W tym celu wywołuje konstruktora bez argumentów,
   * a następnie przypisuje właściwościom właściwości za pomocą setterów.
   *
   * Jeżeli klasa nie ma domyślnego konstruktora, zgłaszany jest następujący wyjątek:
   * org.hibernate.InstantiationException: No default constructor for entity...
   */
  constructor() : this(
    "", "", "", ""
  )
}
