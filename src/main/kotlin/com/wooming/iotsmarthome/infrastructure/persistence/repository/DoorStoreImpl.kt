package com.wooming.iotsmarthome.infrastructure.persistence.repository

import com.wooming.iotsmarthome.domain.door.Door
import com.wooming.iotsmarthome.domain.door.DoorStore
import org.springframework.stereotype.Component

@Component
class DoorStoreImpl: DoorStore {
    override fun storeDoor(door: Door) {
        TODO("Not yet implemented")
    }
}