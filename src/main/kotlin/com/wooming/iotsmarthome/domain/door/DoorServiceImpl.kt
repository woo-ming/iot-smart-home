package com.wooming.iotsmarthome.domain.door

import com.wooming.iotsmarthome.common.exception.EntityAlreadyExistException
import org.springframework.stereotype.Service

@Service
class DoorServiceImpl(
    private val doorReader: DoorReader,
    private val doorStore: DoorStore,
): DoorService {
    override fun registerDoor(name: String): Door {
        val door =  doorReader.findDoorByName(name)
        if(door!=null) throw EntityAlreadyExistException()

        return doorStore.store(Door(name))
    }

    override fun openDoor(doorId: Long): Door {
        val door =  doorReader.findDoorById(doorId)
        door.unlock()
        door.open()
        doorStore.store(door)
        return door
    }

    override fun closeDoor(doorId: Long): Door {
        val door =  doorReader.findDoorById(doorId)
        door.close()
        door.lock()
        doorStore.store(door)
        return door
    }

    override fun lockDoor(doorId: Long): Door {
        val door =  doorReader.findDoorById(doorId)
        door.lock()
        doorStore.store(door)
        return door
    }

    override fun unlockDoor(doorId: Long): Door {
        val door =  doorReader.findDoorById(doorId)
        door.unlock()
        doorStore.store(door)
        return door
    }
}