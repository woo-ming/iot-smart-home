package com.wooming.iotsmarthome.infrastructure.persistence.repository

import com.linecorp.kotlinjdsl.QueryFactory
import com.linecorp.kotlinjdsl.querydsl.expression.column
import com.linecorp.kotlinjdsl.singleQuery
import com.wooming.iotsmarthome.domain.door.Door
import com.wooming.iotsmarthome.domain.door.DoorReader
import org.springframework.stereotype.Component

@Component
class DoorReaderImpl(
    private val queryFactory: QueryFactory
): DoorReader {
    override fun findDoors(): List<Door> {
        TODO("Not yet implemented")
    }

    override fun findDoor(id: Long): Door? {
        return queryFactory.singleQuery<Door> { select(entity(Door::class))
            from(entity(Door::class))
            where(column(Door::id).equal(id))
        }
    }
}