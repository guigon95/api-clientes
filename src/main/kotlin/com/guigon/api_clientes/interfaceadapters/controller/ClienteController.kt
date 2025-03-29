package com.guigon.api_clientes.interfaceadapters.controller

import com.guigon.api_clientes.application.ports.ClienteUseCase
import com.guigon.api_clientes.interfaceadapters.dto.ClienteDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/clientes")
class ClienteController(
    private val clienteUseCase: ClienteUseCase
) {

    @PostMapping
    fun clientes(
        @RequestBody clienteDto: ClienteDto
    ): UUID? {
        clienteUseCase.sendMessage(clienteDto.toString())

        return UUID.randomUUID()
    }
}