package com.wooming.iotsmarthome.domain.door

interface DoorReader {
    fun findDoors(): List<Door>
    fun findDoorById(id: Long): Door
    fun findDoorByName(name: String): Door
}