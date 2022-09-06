package com.wooming.iotsmarthome.interfaces.door.api.dto

import com.wooming.iotsmarthome.domain.door.Door
import com.wooming.iotsmarthome.domain.door.DoorLockStatus
import com.wooming.iotsmarthome.domain.door.DoorStatus
import java.time.LocalDateTime

data class RegisterDoorResponseDto (
    val doorId: Long?,
    val name: String,
    val doorStatus: DoorStatus,
    val doorLockStatus: DoorLockStatus,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
        ) {
    constructor(door: Door) : this (
        door.id, door.name, door.status, door.lockStatus, door.createdAt, door.updatedAt
            )
}