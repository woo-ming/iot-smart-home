package com.wooming.iotsmarthome.common.exception

import com.wooming.iotsmarthome.common.exception.common.BaseException
import com.wooming.iotsmarthome.common.exception.common.ErrorCode

class EntityNotFoundException: BaseException {
    constructor(errorCode: ErrorCode? = null, message: String? = null): super(errorCode?: ErrorCode.COMMON_ENTITY_NOT_FOUND, message?: ErrorCode.COMMON_ENTITY_NOT_FOUND.errorMessage)
}