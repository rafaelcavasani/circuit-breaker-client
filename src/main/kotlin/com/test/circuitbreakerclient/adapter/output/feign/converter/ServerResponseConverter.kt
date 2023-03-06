package com.test.circuitbreakerclient.adapter.output.feign.converter

import com.test.circuitbreakerclient.adapter.output.feign.response.ServerResponse
import com.test.circuitbreakerclient.application.domain.Server

fun ServerResponse.toServer() = Server(
    server = this.server
)