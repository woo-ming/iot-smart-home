package com.wooming.iotsmarthome.domain.door

/**
 * Smart Door 서비스
 * Door Close 시 문이 닫히고 도어락이 잠긴다
 * Door Open 시 문의 도어락 잠금이 풀리고 문이 열린다
 * Door Lock 시 문의 도어락이 잠금 상태가 된다
 * Door Unlock 시 도어락이 잠금 해제 상태가 된다
 */

interface DoorService {
    fun registerDoor(name: String): Door
    fun openDoor(doorId: Long): Door
    fun closeDoor(doorId: Long): Door
    fun lockDoor(doorId: Long): Door
    fun unlockDoor(doorId: Long): Door
}