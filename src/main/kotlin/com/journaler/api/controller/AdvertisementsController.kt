package com.journaler.api.controller

import com.journaler.api.data.AdvertisementCreateDTO
import com.journaler.api.data.AdvertisementDTO
import com.journaler.api.service.AdvertisementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/advertisements")
class AdvertisementsController {

    @Autowired
    private lateinit var service: AdvertisementService


    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun advertisementsList() = service.getAdvertisements()

    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(
            @RequestBody advertisement: AdvertisementCreateDTO
    ) = service.insertAdvertisement(advertisement)

    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(
            @PathVariable(name = "id") id: String
    ) = service.deleteAdvertisement(id)


    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateAdvertisement(
            @RequestBody advertisement: AdvertisementDTO
    ): AdvertisementDTO = service.updateAdvertisement(advertisement)
}