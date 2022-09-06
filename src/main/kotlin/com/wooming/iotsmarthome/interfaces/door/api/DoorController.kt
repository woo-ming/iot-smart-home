package com.wooming.iotsmarthome.interfaces.door.api

import com.wooming.iotsmarthome.application.DoorFacade
import com.wooming.iotsmarthome.common.response.CommonResponse
import com.wooming.iotsmarthome.domain.door.dto.RegisterDoorCommand
import com.wooming.iotsmarthome.interfaces.door.api.dto.OpenDoorRequestDto
import com.wooming.iotsmarthome.common.utill.logger
import com.wooming.iotsmarthome.interfaces.door.api.dto.RegisterDoorRequestDto
import com.wooming.iotsmarthome.interfaces.door.api.dto.RegisterDoorResponseDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/door")
class DoorController (
        private val doorFacade: DoorFacade
        ){

    val log = logger()

    @GetMapping
    fun monitor(): String {
        return "OK"
    }

    @PostMapping
    fun registerDoor(
        @RequestBody dto: RegisterDoorRequestDto
    ): CommonResponse<RegisterDoorResponseDto> {
        val door = doorFacade.registerDoor(dto.name)

        return CommonResponse.success(
            RegisterDoorResponseDto(door)
        )
    }

    @PostMapping("/open")
    fun openDoor(
        @RequestBody dto: OpenDoorRequestDto
    ): HttpStatus {

        log.debug("디버그")
        doorFacade.openDoor(dto.doorId)

        return HttpStatus.OK
    }
}