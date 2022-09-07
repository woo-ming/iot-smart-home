package com.wooming.iotsmarthome.config

import com.amazonaws.services.iot.client.*
import com.wooming.iotsmarthome.infrastructure.iot.awsiot.IotTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class AwsMQTTConfig(
    @Value("\${cloud.aws.iot.endpoint}")
    private val clientEndPoint: String,
    @Value("\${cloud.aws.iot.client-id}")
    private val clientId: String,
    @Value("\${cloud.aws.credentials.access-key}")
    private val accessKey: String,
    @Value("\${cloud.aws.credentials.secret-key}")
    private val secretKey: String
) {
    private lateinit var client: AWSIotMqttClient

    @Throws(AWSIotException::class)
    fun connectToIot() {
        // AWS IAM credentials could be retrieved from AWS Cognito, STS, or other secure sources
        client = AWSIotMqttClient(clientEndPoint, clientId, accessKey, secretKey)
        client.connect()
        val topic = IotTopic("/door/open", AWSIotQos.QOS0)
        client.subscribe(topic)
    }

    fun publish(message: AWSIotMessage, timeout: Long = 3000) {
        client.publish(message, timeout)
    }
}