package com.journaler.api.repository

import com.journaler.api.data.Advertisement
import org.springframework.data.repository.CrudRepository

interface AdvertisementRepository : CrudRepository<Advertisement, String>