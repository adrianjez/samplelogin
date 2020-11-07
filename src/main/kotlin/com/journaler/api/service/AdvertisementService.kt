package com.journaler.api.service

import com.journaler.api.data.Advertisement
import com.journaler.api.data.AdvertisementCreateDTO
import com.journaler.api.data.AdvertisementDTO
import com.journaler.api.repository.AdvertisementRepository
import com.journaler.api.repository.PhotoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("Advertisement Service")
class AdvertisementService {

    @Autowired
    lateinit var repository: AdvertisementRepository

    @Autowired
    lateinit var photosRepository: PhotoRepository

    fun getAdvertisements(): Iterable<AdvertisementDTO> = repository.findAll()
            .map { AdvertisementDTO(it) }


    fun insertAdvertisement(advertDTO: AdvertisementCreateDTO) = AdvertisementDTO(
            repository.save(
                    Advertisement(
                            title = advertDTO.title,
                            description = advertDTO.description,
                            date = advertDTO.date,
                            longitude = advertDTO.longitude,
                            latitude = advertDTO.latitude,
                            userEmail = advertDTO.userEmail,
                            userPhone = advertDTO.userPhone,
                            userCity = advertDTO.userCity,
                            photos = advertDTO.photos.map {
                                photosRepository.findById(it).get()
                            }
                    )
            )
    )

    fun deleteAdvertisement(id: String) = repository.deleteById(id)

    fun updateAdvertisement(advertDTO: AdvertisementDTO): AdvertisementDTO {
        var advert = repository.findById(advertDTO.id).get()
        advert.title = advertDTO.title
        advert.description = advertDTO.description
        advert.date = advertDTO.date
        advert.longitude = advertDTO.longitude
        advert.latitude = advertDTO.latitude
        advert.userEmail = advertDTO.userEmail
        advert.userPhone = advertDTO.userPhone
        advert.userCity = advertDTO.userCity
        advert.photos = advertDTO.photos

        return AdvertisementDTO(advert)
    }
}