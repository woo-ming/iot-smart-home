package com.wooming.iotsmarthome.application

import com.wooming.iotsmarthome.domain.door.DoorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DoorFacade(
    @Autowired
    private val doorService: DoorService
): DoorService by doorService