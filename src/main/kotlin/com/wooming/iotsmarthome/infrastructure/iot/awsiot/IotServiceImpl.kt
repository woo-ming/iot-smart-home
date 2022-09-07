package com.wooming.iotsmarthome.infrastructure.iot.awsiot

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

    override fun publishMessage(topic: String, message: Any) {
        //Connect
        awsMqttConfig.connectToIot()

        //Create Message
        val message = IoTControlMessage.of(topic, AWSIotQos.QOS0, message)

        //Publish Message
        awsMqttConfig.publish(message)

        log.info("Publishing message to topic: $topic")
    }
}