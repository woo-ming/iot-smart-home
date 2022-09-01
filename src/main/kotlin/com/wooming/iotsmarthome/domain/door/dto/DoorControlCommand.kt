package com.wooming.iotsmarthome.domain.door.dto

import com.wooming.iotsmarthome.domain.door.DoorStatus

data class DoorControlCommand (
    val doorId: Long,
    val status: DoorStatus
        )