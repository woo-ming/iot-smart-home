package com.wooming.iotsmarthome.infrastructure.iot.awsiot

import com.amazonaws.services.iot.client.AWSIotMessage
import com.amazonaws.services.iot.client.AWSIotQos
import com.google.gson.Gson
import java.time.LocalDateTime
import java.util.UUID

class IoTControlMessage(topic: String?, qos: AWSIotQos?, payload: String?) : AWSIotMessage(topic, qos, payload) {
//    constructor(topic: String, qos: AWSIotQos, payload: String): super(topic, qos, payload)

    companion object {
        fun of(topic: String, qos: AWSIotQos, payload: Any): AWSIotMessage {
            val gson = Gson()
            val convertedPayload = gson.toJson(BaseMessage(payload))

            return AWSIotMessage(topic, qos, convertedPayload)
        }
    }

    override fun onSuccess() {
        super.onSuccess()
    }

    override fun onFailure() {
        super.onFailure()
    }

    override fun onTimeout() {
        super.onTimeout()
    }
}


class BaseMessage<T>(
    payload: T
) {
    val common_id = UUID.randomUUID().toString()
    val protocol_ver = "0.0.1"
    val command = "control"
    val timestamp = LocalDateTime.now().toString()
    val expired_at = LocalDateTime.now().plusDays(3).toString()
    val param = payload
}