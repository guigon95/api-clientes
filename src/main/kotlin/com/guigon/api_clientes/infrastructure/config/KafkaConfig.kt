package com.guigon.api_clientes.infrastructure.config

import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.kafka.sender.SenderOptions

@Configuration
class KafkaConfig(

    @Value("\${spring.kafka.bootstrap-servers}") private var boostrapServers: String
) {

    @Bean
    fun reactiveKafkaProducerTemplate(): ReactiveKafkaProducerTemplate<String, String> {
        val senderOptions = SenderOptions.create<String, String>(mapOf(
            "bootstrap.servers" to boostrapServers,
            "key.serializer" to StringSerializer::class.java,
            "value.serializer" to StringSerializer::class.java
        ))

        return ReactiveKafkaProducerTemplate(senderOptions)
    }
}