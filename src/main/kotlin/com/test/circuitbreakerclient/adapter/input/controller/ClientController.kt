package com.test.circuitbreakerclient.adapter.input.controller

import com.test.circuitbreakerclient.adapter.input.api.ClientApi
import com.test.circuitbreakerclient.adapter.input.api.converter.toClientResponse
import com.test.circuitbreakerclient.adapter.input.api.response.ClientResponse
import com.test.circuitbreakerclient.application.port.input.GetClientUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ClientController(
    private val getServerUseCase: GetClientUseCase
) : ClientApi {

    override fun get(): ResponseEntity<List<ClientResponse>> {
        val listResult = getServerUseCase.getServer().map { it.toClientResponse() }
        return ResponseEntity.ok(listResult)
    }

}