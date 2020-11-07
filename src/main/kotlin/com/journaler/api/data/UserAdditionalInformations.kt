package com.journaler.api.data

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "user_additionalinformations")
@NamedQuery(
        name = "UserAdditionalInformations.findByEmail",
        query = "SELECT n FROM Note n WHERE userEmail LIKE ?1"
)
data class UserAdditionalInformations(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "varchar(36)")
        var id: String = "",

        var userPhone: String,
        var longitude: Double,
        var latitude: Double,
        var street: String,
        var city: String,
        var zipCode: String,
        var houseNumber: String,
        var apartmentNumber: String?
) {
    constructor() : this("", "",
            0.0, 0.0, "", "", "", "", "")
}
