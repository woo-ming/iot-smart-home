package com.wooming.iotsmarthome.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.iot.AWSIot
import com.amazonaws.services.iot.AWSIotClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class AWSIotConfig(

    @Value("\${aws.iot.mqtt.clientId}")
    private val clientId: String,
    @Value("\${aws.iot.iam.accessKey}")
    private val accessKey: String,
    @Value("\${aws.iot.iam.secretKey}")
    private val secretKey: String,
) {

    fun getIotClient(): AWSIot {
        return AWSIotClientBuilder.standard()
            .withCredentials((
                    AWSStaticCredentialsProvider(
                        BasicAWSCredentials(
                            accessKey,
                            secretKey
                        )
                    )))
            .withRegion(Regions.AP_NORTHEAST_2).build()
    }
}