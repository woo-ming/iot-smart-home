package com.wooming.iotsmarthome.infrastructure.iot.awsiot

import com.amazonaws.services.iot.client.AWSIotMessage
import com.amazonaws.services.iot.client.AWSIotQos
import com.amazonaws.services.iot.client.AWSIotTopic
import com.google.gson.Gson
import com.wooming.iotsmarthome.common.utill.logger

class IotTopic(topic: String?, qos: AWSIotQos?): AWSIotTopic(topic, qos) {
    private val log = logger()

    override fun onMessage(message: AWSIotMessage) {
        val gson = Gson()

        log.info("Message received: ${gson.toJson(message.stringPayload)}")
        super.onMessage(message)
    }
}