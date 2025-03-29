package com.guigon.api_clientes.application.usecase

import com.guigon.api_clientes.application.ports.ClienteUseCase
import com.guigon.api_clientes.application.ports.KafkaProducerPort
import reactor.core.publisher.Mono
import java.util.*

class ClienteUseCaseImpl(
    private val kafkaProducerPort: KafkaProducerPort
) : ClienteUseCase {
    override fun sendMessage(message: String): Mono<Void> {
        return kafkaProducerPort.sendMessage(message)
    }
}