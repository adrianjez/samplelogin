package com.journaler.api.data

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "photos")
data class PhotoEntity (
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "varchar(36)")
        var id: String = "",

        var url: String
) {
        constructor() : this("", "")
}