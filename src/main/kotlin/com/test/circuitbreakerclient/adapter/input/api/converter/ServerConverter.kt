package com.test.circuitbreakerclient.adapter.input.api.converter

import com.test.circuitbreakerclient.adapter.input.api.response.ClientResponse
import com.test.circuitbreakerclient.application.domain.Server

fun Server.toClientResponse() = ClientResponse(
    this.server
)
