package com.wooming.iotsmarthome.common.exception.common

enum class ErrorCode(val errorMessage: String) {
    COMMON_ENTITY_NOT_FOUND("찾을 수 없는 엔티티에요"),
    COMMON_ENTITY_ALREADY_EXIST("존재하는 엔티티에요"),
}