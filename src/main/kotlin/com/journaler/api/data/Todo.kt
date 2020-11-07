package com.journaler.api.data

import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "todo")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Todo(
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "varchar(36)")
  var id: String = "",
  var title: String,
  var message: String,
  var schedule: Long,
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
    "", "", "", -1, ""
  )
}