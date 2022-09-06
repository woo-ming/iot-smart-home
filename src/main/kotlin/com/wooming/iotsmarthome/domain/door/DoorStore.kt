package com.wooming.iotsmarthome.domain.door

interface DoorStore {
    fun store(door: Door): Door
}