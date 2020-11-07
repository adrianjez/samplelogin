package com.journaler.api.data

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "advertisements")
data class Advertisement(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "varchar(36)")
        var id: String = "",
        var title: String,
        var description: String,
        var date: Long,
        var longitude: Double,
        var latitude: Double,
        var userEmail: String,
        var userPhone: String,
        var userCity: String,

        @Column(nullable = false)
        @OneToMany(cascade = [CascadeType.ALL])
        var photos: List<PhotoEntity>
) {
        constructor() : this("", "",
                "", 0L, 0.0, 0.0,
                "", "", "", arrayListOf())
}