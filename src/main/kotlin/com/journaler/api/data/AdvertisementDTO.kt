package com.journaler.api.data

data class AdvertisementDTO (
        var title: String,
        var description: String,
        var date: Long,
        var longitude: Double,
        var latitude: Double,
        var userEmail: String,
        var userPhone: String,
        var userCity: String,

        val photos: List<PhotoEntity>
) {
    var id: String = ""

    constructor(advertisement: Advertisement) : this(
            advertisement.title,
            advertisement.description,
            advertisement.date,
            advertisement.longitude,
            advertisement.latitude,
            advertisement.userEmail,
            advertisement.userPhone,
            advertisement.userCity,
            advertisement.photos
    ){
        this.id = advertisement.id
    }
}