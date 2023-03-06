package com.test.circuitbreakerclient.adapter.input.api

import com.test.circuitbreakerclient.adapter.input.api.response.ClientResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/client")
interface ClientApi {


    @GetMapping
    fun get(): ResponseEntity<List<ClientResponse>>

}