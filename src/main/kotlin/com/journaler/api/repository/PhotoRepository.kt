package com.journaler.api.repository

import com.journaler.api.data.PhotoEntity
import org.springframework.data.repository.CrudRepository


interface PhotoRepository : CrudRepository<PhotoEntity, String>