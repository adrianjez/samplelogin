package com.journaler.api.controller

import com.journaler.api.data.UserAdditionalInformationsDTO
import com.journaler.api.service.UserAdditionalInformationsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/additionalInformartions")
class UserAdditionalInformationsConsoller {

    @Autowired
    private lateinit var service: UserAdditionalInformationsService

    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAdditionalInformations(@RequestParam("userEmail") email: String) =
            service.getAdditionalInformations(email)


    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertAdditionalInformations(
            @RequestBody userAdditionalInformations: UserAdditionalInformationsDTO
    ) = service.insertUserAdditionalInformations(userAdditionalInformations)


    @DeleteMapping(
            value = ["/{email}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(
            @PathVariable(name = "email") id: String
    ) = service.deleteUserAdditionalInformations(id)


    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateAdvertisement(
            @RequestBody userAdditionalInformations: UserAdditionalInformationsDTO
    ): UserAdditionalInformationsDTO = service.updateUserAdditionalInformations(userAdditionalInformations)

}