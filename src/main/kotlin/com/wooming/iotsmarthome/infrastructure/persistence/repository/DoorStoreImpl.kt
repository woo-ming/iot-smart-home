package com.wooming.iotsmarthome.infrastructure.persistence.repository

import com.wooming.iotsmarthome.domain.door.Door
import com.wooming.iotsmarthome.domain.door.DoorStore
import org.springframework.stereotype.Repository

@Repository
class DoorStoreImpl(
    val doorRepository: DoorRepository
): DoorStore {
    override fun store(door: Door): Door {
        return doorRepository.save(door)
    }
}