package com.wooming.iotsmarthome.infrastructure.iot

interface IotService {
    fun publishMessage(topic: String, message: Any)

//    fun subscribeMessage()
}