package com.wooming.iotsmarthome.domain.door

import com.wooming.iotsmarthome.infrastructure.iot.IotService
import org.springframework.stereotype.Service

@Service
class DoorServiceImpl(
    private val iotService: IotService,
    private val doorReader: DoorReader,
    private val doorStore: DoorStore,
): DoorService {
    override fun openDoor(doorId: Long) {
        iotService.publishMessage("door/open", doorId.toString())
        TODO("Not yet implemented")
    }

    override fun closeDoor(doorId: Long) {
        TODO("Not yet implemented")
    }

    override fun lockDoor(doorId: Long) {
        TODO("Not yet implemented")
    }

    override fun unlockDoor(doorId: Long) {
        TODO("Not yet implemented")
    }
}