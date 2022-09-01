package com.wooming.iotsmarthome.domain.door

interface DoorReader {
    fun findDoors(): List<Door>
    fun findDoor(id: Long): Door?
}