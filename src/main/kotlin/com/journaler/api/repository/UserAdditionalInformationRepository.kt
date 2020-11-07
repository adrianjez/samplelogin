package com.journaler.api.repository

import com.journaler.api.data.UserAdditionalInformations
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserAdditionalInformationRepository : CrudRepository<UserAdditionalInformations, String>{
    fun findByEmail(email: String): Optional<UserAdditionalInformations>
}