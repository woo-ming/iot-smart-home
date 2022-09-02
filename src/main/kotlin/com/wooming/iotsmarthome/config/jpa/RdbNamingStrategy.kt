package com.wooming.iotsmarthome.config.jpa

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.ImplicitForeignKeyNameSource
import org.hibernate.boot.model.naming.ImplicitIndexNameSource
import org.hibernate.boot.model.naming.ImplicitUniqueKeyNameSource
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
import org.springframework.context.annotation.Configuration

@Configuration
class RdbNamingStrategy: SpringImplicitNamingStrategy() {
    override fun determineForeignKeyName(source: ImplicitForeignKeyNameSource): Identifier {
        val columnNameList = source.columnNames.map{camelToSnakeCase(it.toString())}
        return toIdentifier(
            "${source.tableName.canonicalName}_${columnNameList.joinToString("_")}_fkey",
            source.buildingContext
        )
    }

    override fun determineUniqueKeyName(source: ImplicitUniqueKeyNameSource): Identifier {
        val columnNameList = source.columnNames.map{camelToSnakeCase(it.toString())}
        return toIdentifier(
            "${source.tableName.canonicalName}_uk_${columnNameList.joinToString("_")}",
            source.buildingContext
        )
    }

    override fun determineIndexName(source: ImplicitIndexNameSource): Identifier {
        val columnNameList = source.columnNames.map{camelToSnakeCase(it.toString())}
        return toIdentifier(
            "${source.tableName.canonicalName}_ix_${columnNameList.joinToString("_")}",
            source.buildingContext
        )
    }

    private fun camelToSnakeCase(camelCase: String): String {
        val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
        return camelRegex.replace(camelCase) {
            "_${it.value}"
        }.lowercase()
    }
}