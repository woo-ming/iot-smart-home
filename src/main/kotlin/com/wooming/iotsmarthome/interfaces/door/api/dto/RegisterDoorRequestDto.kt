package com.wooming.iotsmarthome.interfaces.door.api.dto

import com.wooming.iotsmarthome.domain.door.dto.RegisterDoorCommand

data class RegisterDoorRequestDto (
    val name: String
        ) {
    fun toCommand(): RegisterDoorCommand {
        return RegisterDoorCommand(
            this.name
        )
    }
}