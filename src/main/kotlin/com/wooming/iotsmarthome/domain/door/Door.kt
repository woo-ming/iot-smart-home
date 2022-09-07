package com.wooming.iotsmarthome.domain.door

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "door", indexes = [Index(columnList = "name", unique = true)])
data class Door (
    @Column
    var name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column
    var status: DoorStatus = DoorStatus.CLOSE

    @Column
    var lockStatus: DoorLockStatus = DoorLockStatus.UNLOCK

    @Column(nullable = false)
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()


    fun open() {
        status = DoorStatus.OPEN
    }

    fun close() {
        status = DoorStatus.CLOSE
    }

    fun lock() {
        lockStatus = DoorLockStatus.LOCK
    }

    fun unlock() {
        lockStatus = DoorLockStatus.UNLOCK
    }
}

enum class DoorStatus {
    OPEN,
    CLOSE,
}

enum class DoorLockStatus {
    LOCK,
    UNLOCK,
}