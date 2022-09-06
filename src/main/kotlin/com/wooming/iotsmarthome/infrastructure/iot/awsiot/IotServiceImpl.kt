package com.wooming.iotsmarthome.infrastructure.iot.awsiot

import com.amazonaws.services.iot.client.AWSIotMessage
import com.amazonaws.services.iot.client.AWSIotQos
import com.wooming.iotsmarthome.config.AwsMQTTConfig
import com.wooming.iotsmarthome.infrastructure.iot.IotService
import com.wooming.iotsmarthome.common.utill.logger
import org.springframework.stereotype.Service

@Service
class IotServiceImpl(
    private val awsMqttConfig: AwsMQTTConfig
): IotService {
    val log = logger()

    override fun publishMessage(topic: String, message: String) {
        //Connect
        awsMqttConfig.connectToIot()

        //Create Message
        val message = AWSIotMessage(topic, AWSIotQos.QOS0, message)

        //Publish Message
        awsMqttConfig.publish(message)

        log.debug("Publishing message to topic: $topic")
    }
}