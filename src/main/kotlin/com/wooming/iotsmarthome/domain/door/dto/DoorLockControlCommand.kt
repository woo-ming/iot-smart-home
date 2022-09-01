package com.wooming.iotsmarthome.domain.door.dto

import com.wooming.iotsmarthome.domain.door.DoorLockStatus

data class DoorLockControlCommand (
    val doorId: Long,
    val doorLockStatus: DoorLockStatus
        )