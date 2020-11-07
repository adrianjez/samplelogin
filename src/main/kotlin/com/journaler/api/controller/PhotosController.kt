package com.journaler.api.controller

import com.journaler.api.data.PhotoEntity
import com.journaler.api.data.PhotoEntityDTO
import com.journaler.api.repository.PhotoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
class PhotosController {

    @Autowired
    private lateinit var photoRepository: PhotoRepository

    @PostMapping("/uploadPhoto")
    fun uploadPhoto(@RequestParam("file") file: MultipartFile): PhotoEntityDTO? {

        /*
        val FTP_ADDRESS = "your_address"
        val LOGIN = "you_login"
        val PSW = "you_password"

        var con: FTPClient? = null
        var newFileName = UUID.randomUUID()
        try {
            con = FTPClient()
            con.connect(FTP_ADDRESS)
            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode() // important!
                con.setFileType(FILE.value)
                val result: Boolean = con.storeFile(newFileName.toString(), file.inputStream)
                con.logout()
                con.disconnect()
                return null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

         */
            // We have URL https://hqapps.ddns.net/
        return PhotoEntityDTO(
                photoRepository.save(
                        PhotoEntity(
                                url = "https://hqapps.ddns.net/" + UUID.randomUUID().toString()
                                //FTP_ADDRESS + File.separator + newFileName.toString()
                        )
                ))
    }

}