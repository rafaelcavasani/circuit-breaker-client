package com.test.circuitbreakerclient.adapter.output.feign

import com.test.circuitbreakerclient.adapter.output.feign.client.ServerClient
import com.test.circuitbreakerclient.adapter.output.feign.converter.toServer
import com.test.circuitbreakerclient.application.domain.Server
import com.test.circuitbreakerclient.application.port.output.ServerPort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ServerClientService(
    private val serverClient: ServerClient
) : ServerPort {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun getServer(): List<Server> {
        logger.info("Executou o client.")
        return serverClient.getServer().map { it.toServer() }
    }
}