package com.wooming.iotsmarthome.domain.door

import com.wooming.iotsmarthome.common.exception.EntityAlreadyExistException
import com.wooming.iotsmarthome.common.exception.EntityNotFoundException
import com.wooming.iotsmarthome.infrastructure.iot.IotService
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.BadRequest

@Service
class DoorServiceImpl(
    private val iotService: IotService,
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

        iotService.publishMessage("/door/open", doorId.toString())
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