package com.wooming.iotsmarthome.domain.door

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "door")
data class Door (
    @Column(unique = true)
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

    fun modifyStatus(status: DoorStatus) {
        this.status = status
    }

    fun modifyLockStatus(lockStatus: DoorLockStatus) {
        this.lockStatus = lockStatus
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