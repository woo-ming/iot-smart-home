package com.wooming.iotsmarthome.common.response

class CommonResponse<T> (
    val result: Result,
    val data: T? = null,
    val message: String? = null,
    val errorCode: String? = null,
        ){

    companion object {
        fun fail(message: String?, errorCode: String): CommonResponse<Any> {
            return CommonResponse(Result.FAIL, message = message, errorCode = errorCode)
        }

        fun <T> success(data: T) : CommonResponse<T> {
            return CommonResponse(Result.SUCCESS, data)
        }

        fun success() : CommonResponse<Any> {
            return CommonResponse(Result.SUCCESS)
        }
    }

    enum class Result {
        SUCCESS,
        FAIL,
    }
}