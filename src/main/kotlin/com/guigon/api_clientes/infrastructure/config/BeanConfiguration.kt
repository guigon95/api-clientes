package com.guigon.api_clientes.infrastructure.config

import com.guigon.api_clientes.application.ports.ClienteUseCase
import com.guigon.api_clientes.application.ports.KafkaProducerPort
import com.guigon.api_clientes.application.usecase.ClienteUseCaseImpl
import com.guigon.api_clientes.infrastructure.kafka.KafkaProducerAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate

@Configuration
class BeanConfiguration {

    @Bean
    fun clienteUseCase(
        kafkaProducerPort: KafkaProducerPort
    ): ClienteUseCase {
        return ClienteUseCaseImpl(kafkaProducerPort)
    }

    @Bean
    fun kafkaProducerPort(
        reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, String>,
        @Value("\${kafka.topic}") topic: String
    ): KafkaProducerPort {
        return KafkaProducerAdapter(reactiveKafkaProducerTemplate, topic)
    }

}