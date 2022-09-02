package com.wooming.iotsmarthome.infrastructure.persistence.repository

import com.wooming.iotsmarthome.domain.door.Door
import com.wooming.iotsmarthome.domain.door.DoorReader
import org.springframework.stereotype.Component

@Component
class DoorReaderImpl: DoorReader {
    override fun findDoors(): List<Door> {
        TODO("Not yet implemented")
    }

    override fun findDoor(id: Long): Door? {
        TODO("Not yet implemented")
    }
}