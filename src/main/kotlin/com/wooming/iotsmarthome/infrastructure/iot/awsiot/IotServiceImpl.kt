package com.wooming.iotsmarthome.infrastructure.iot.awsiot

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
        awsMqttConfig.connectToIot()
        log.debug("Publishing message to topic: $topic")
    }
}