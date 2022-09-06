package com.wooming.iotsmarthome.infrastructure.persistence.repository

import com.wooming.iotsmarthome.domain.door.Door
import org.springframework.data.jpa.repository.JpaRepository

interface DoorRepository: JpaRepository <Door, Long> {
}