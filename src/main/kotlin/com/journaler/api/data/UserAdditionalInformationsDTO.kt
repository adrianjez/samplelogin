package com.journaler.api.data

data class UserAdditionalInformationsDTO(
        var userPhone: String,
        var longitude: Double,
        var latitude: Double,
        var street: String,
        var city: String,
        var zipCode: String,
        var houseNumber: String,
        var apartmentNumber: String?
) {
    var id = ""

    constructor(userAdditionalInformations: UserAdditionalInformations) : this(
            userAdditionalInformations.userPhone,
            userAdditionalInformations.longitude,
             userAdditionalInformations.latitude,
            userAdditionalInformations.street,
             userAdditionalInformations.city,
            userAdditionalInformations.zipCode,
            userAdditionalInformations.houseNumber,
            userAdditionalInformations.apartmentNumber
    ){
        this.id = userAdditionalInformations.id
    }
}