package com.journaler.api

import com.jayway.jsonpath.internal.path.PathCompiler.fail
import com.journaler.api.security.Admin
import com.journaler.api.security.Member
import com.journaler.api.security.UserDTO
import com.journaler.api.service.UserService
import org.assertj.core.api.Assert
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class SecurityInitializationTest {

  @Autowired
  private lateinit var userService: UserService

  private val password = "12345"
  private val adminEmail = "admin@adres.com"
  private val memberEmail = "member@adres.com"

  @Test
  fun initAdmin() {
    try {
      val admin = userService.loadUserByUsername(adminEmail)
      if (admin is Admin) {
        println("Konto administratora ${admin.id} już istnieje.")
      } else {
        fail("To nie jest konto administratora.")
      }
    } catch (e: RuntimeException) {
      val toSave = UserDTO(
        adminEmail,
        password,
        "admin",
        "admin"
      )
      val saved = userService.saveAdmin(toSave)
      println("Utworzono konto administratora ${saved.id}.")
    }
  }

  @Test
  fun initMember() {
    try {
      val member = userService.loadUserByUsername(memberEmail)
      if (member is Member) {
        println("Konto użytkownika ${member.id} już istnieje.")
      } else {
        fail("To nie jest konto użytkownika.")
      }
    } catch (e: RuntimeException) {
      val toSave = UserDTO(
        memberEmail,
        password,
        "member",
        "member"
      )
      val saved = userService.saveMember(toSave)
      println("Utworzono konto użytkownika ${saved.id}.")
    }
  }
}