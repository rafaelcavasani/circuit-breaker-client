package com.test.circuitbreakerclient.application.port.input

import com.test.circuitbreakerclient.application.domain.Server

interface GetClientUseCase {
    fun getServer(): List<Server>
}