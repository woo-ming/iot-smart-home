package com.wooming.iotsmarthome.common.exception

import com.wooming.iotsmarthome.common.exception.common.BaseException
import com.wooming.iotsmarthome.common.exception.common.ErrorCode

class EntityAlreadyExistException: BaseException {
    constructor(errorCode: ErrorCode? = null, message: String? = null): super(errorCode?: ErrorCode.COMMON_ENTITY_ALREADY_EXIST, message?: ErrorCode.COMMON_ENTITY_ALREADY_EXIST.errorMessage)
}