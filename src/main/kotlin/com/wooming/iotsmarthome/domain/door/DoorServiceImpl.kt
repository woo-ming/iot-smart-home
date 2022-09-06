package com.wooming.iotsmarthome.domain.door

import com.wooming.iotsmarthome.infrastructure.iot.IotService
import org.springframework.stereotype.Service

@Service
class DoorServiceImpl(
    private val iotService: IotService,
    private val doorReader: DoorReader,
    private val doorStore: DoorStore,
): DoorService {
    override fun registerDoor(name: String): Door {
        return doorStore.store(Door(name))
    }

    override fun openDoor(doorId: Long): Door {
        iotService.publishMessage("door/open", doorId.toString())
        TODO("Not yet implemented")
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