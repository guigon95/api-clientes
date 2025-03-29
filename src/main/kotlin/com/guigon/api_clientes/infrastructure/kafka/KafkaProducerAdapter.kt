package com.guigon.api_clientes.infrastructure.kafka

import com.guigon.api_clientes.application.ports.KafkaProducerPort
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.core.publisher.Mono

class KafkaProducerAdapter(
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, String>,
    @Value("\${kafka.topic}") private val topic: String
) : KafkaProducerPort {

    private val logger = LoggerFactory.getLogger(KafkaProducerAdapter::class.java)

    override fun sendMessage(message: String): Mono<Void> {
        logger.info("Sending message: $message")
        return reactiveKafkaProducerTemplate.send(topic, message)
            .doOnSuccess { logger.info("Message sent: $message") }
            .doOnError { e -> logger.error("Error sending message: $e") }
            .then()
    }
}