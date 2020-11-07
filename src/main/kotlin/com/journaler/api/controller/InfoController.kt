package com.journaler.api.controller

import org.springframework.http.MediaType
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/info")
class InfoController {

    @GetMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getInfo() : String {
        return if(SecurityContextHolder.getContext().authentication.principal as? UserDetails != null){
            (SecurityContextHolder.getContext().authentication.principal as UserDetails).username
        } else {
            SecurityContextHolder.getContext().authentication.principal.toString()
        }
    }
}