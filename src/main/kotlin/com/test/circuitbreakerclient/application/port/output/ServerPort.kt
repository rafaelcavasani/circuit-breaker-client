package com.test.circuitbreakerclient.application.port.output

import com.test.circuitbreakerclient.application.domain.Server

interface ServerPort {
    fun getServer(): List<Server>
}