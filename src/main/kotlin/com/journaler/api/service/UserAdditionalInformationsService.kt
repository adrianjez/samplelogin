package com.journaler.api.service

import com.journaler.api.data.UserAdditionalInformations
import com.journaler.api.data.UserAdditionalInformationsDTO
import com.journaler.api.repository.UserAdditionalInformationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("UserAdditionalInformations Service")
class UserAdditionalInformationsService {

    @Autowired
    lateinit var repository: UserAdditionalInformationRepository

    fun getAdditionalInformations(email: String) = repository.findByEmail(email).get()

    fun insertUserAdditionalInformations(userAdditionalInformationsDTO: UserAdditionalInformationsDTO) =
            repository.save(
                    UserAdditionalInformations(
                            userPhone = userAdditionalInformationsDTO.userPhone,
                            longitude = userAdditionalInformationsDTO.longitude,
                            latitude = userAdditionalInformationsDTO.latitude,
                            street = userAdditionalInformationsDTO.street,
                            city = userAdditionalInformationsDTO.city,
                            zipCode = userAdditionalInformationsDTO.zipCode,
                            houseNumber = userAdditionalInformationsDTO.houseNumber,
                            apartmentNumber = userAdditionalInformationsDTO.apartmentNumber
                    )
            )

    fun deleteUserAdditionalInformations(byEmail: String){
        repository.delete(repository.findByEmail(byEmail).get())
    }

    fun updateUserAdditionalInformations(userAdditionalInformationsDTO: UserAdditionalInformationsDTO) : UserAdditionalInformationsDTO {
        var userAdditionalInformations = repository.findById(userAdditionalInformationsDTO.id).get()
        userAdditionalInformations.userPhone = userAdditionalInformationsDTO.userPhone
        userAdditionalInformations.longitude = userAdditionalInformationsDTO.longitude
        userAdditionalInformations.latitude = userAdditionalInformationsDTO.latitude
        userAdditionalInformations.street = userAdditionalInformationsDTO.street
        userAdditionalInformations.city = userAdditionalInformationsDTO.city
        userAdditionalInformations.zipCode = userAdditionalInformationsDTO.zipCode
        userAdditionalInformations.houseNumber = userAdditionalInformationsDTO.houseNumber
        userAdditionalInformations.apartmentNumber = userAdditionalInformationsDTO.apartmentNumber
        return UserAdditionalInformationsDTO(userAdditionalInformations)
    }

}