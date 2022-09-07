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
        door.modifyLockStatus(DoorLockStatus.UNLOCK)
        door.modifyStatus(DoorStatus.OPEN)
        doorStore.store(door)
        return door
    }

    override fun closeDoor(doorId: Long): Door {
        TODO("Not yet implemented")
    }

    override fun lockDoor(doorId: Long): Door {
        TODO("Not yet implemented")
    }

    override fun unlockDoor(doorId: Long): Door {
        TODO("Not yet implemented")
    }
}