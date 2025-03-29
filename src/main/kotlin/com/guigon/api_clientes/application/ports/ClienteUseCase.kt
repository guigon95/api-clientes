package com.guigon.api_clientes.application.ports

import reactor.core.publisher.Mono

interface ClienteUseCase {
    fun sendMessage(message: String): Mono<Void>
}