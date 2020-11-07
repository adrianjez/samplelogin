package com.journaler.api.data

data class PhotoEntityDTO (
    val url: String
){
    var id: String = ""

    constructor(photoEntity: PhotoEntity) : this(photoEntity.url) {
        this.id = photoEntity.id
    }
}