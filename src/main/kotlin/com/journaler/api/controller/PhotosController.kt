package com.journaler.api.controller

import com.journaler.api.data.PhotoEntity
import com.journaler.api.data.PhotoEntityDTO
import com.journaler.api.repository.PhotoRepository
import org.apache.commons.net.ftp.FTPClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.print.attribute.standard.ReferenceUriSchemesSupported.FILE

@RestController
class PhotosController {

    @Autowired
    private lateinit var photoRepository: PhotoRepository

    @PostMapping("/uploadPhoto")
    fun uploadPhoto(@RequestParam("file") file: MultipartFile): PhotoEntityDTO? {


        val FTP_ADDRESS = "files.000webhost.com"
        val LOGIN = "portalogloszen2"
        val PSW = "svbJdgIb(qz3fW%xG)pr"

        var con: FTPClient? = null
        var newFileName = UUID.randomUUID().toString() + ".png"
        try {
            con = FTPClient()
            con.connect(FTP_ADDRESS)
            if (con.login(LOGIN, PSW)) {
                con.enterLocalPassiveMode() // important!
                con.setFileType(FTPClient.BINARY_FILE_TYPE)
                val result: Boolean = con.storeFile("/public_html/$newFileName", file.inputStream)
                con.logout()
                con.disconnect()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        return PhotoEntityDTO(
                photoRepository.save(
                        PhotoEntity(
                                url = "https://portalogloszen2.000webhostapp.com/$newFileName"
                        )
                ))
    }

}