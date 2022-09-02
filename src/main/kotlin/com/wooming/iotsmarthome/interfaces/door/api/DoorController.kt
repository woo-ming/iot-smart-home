package com.wooming.iotsmarthome.interfaces.door.api

import com.wooming.iotsmarthome.application.DoorFacade
import com.wooming.iotsmarthome.interfaces.door.api.dto.OpenDoorRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/door")
class DoorController (
        private val doorFacade: DoorFacade
        ){

    @PostMapping("/open")
    fun openDoor(
        @RequestBody dto: OpenDoorRequestDto
    ) {
        doorFacade.openDoor(dto.doorId)
    }
}