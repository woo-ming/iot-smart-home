package com.wooming.iotsmarthome.common.exception.common

open class BaseException : RuntimeException {
    private val errorCode: ErrorCode

    constructor(errorCode: ErrorCode, message: String? = errorCode.errorMessage, cause: Throwable? = null): super(message, cause) {
        this.errorCode = errorCode
    }
}