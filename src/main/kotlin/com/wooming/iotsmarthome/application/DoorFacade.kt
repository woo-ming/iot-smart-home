package com.wooming.iotsmarthome.application

import com.wooming.iotsmarthome.domain.door.Door
import com.wooming.iotsmarthome.domain.door.DoorService
import com.wooming.iotsmarthome.infrastructure.iot.IotService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DoorFacade(
    @Autowired
    private val doorService: DoorService,
    private val iotService: IotService
): DoorService by doorService {

    @Transactional
    override fun openDoor(doorId: Long): Door {
        val door = doorService.openDoor(doorId)
        iotService.publishMessage("/door/open", doorId.toString())
        return door
    }
}