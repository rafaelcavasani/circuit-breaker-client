package com.test.circuitbreakerclient.application.service

import com.test.circuitbreakerclient.application.domain.Server
import com.test.circuitbreakerclient.application.port.input.GetClientUseCase
import com.test.circuitbreakerclient.application.port.output.ServerPort
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.retry.annotation.Retry
import org.slf4j.LoggerFactory
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory
import org.springframework.stereotype.Service


@Service
class GetClientService(
    private val serverPort: ServerPort,
    private val circuitBreakerFactory: CircuitBreakerFactory<*, *>
) : GetClientUseCase {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
        const val RESILIENCE4J_INSTANCE_NAME = "SERVER_CIRCUIT_BREAKER"
        const val FALLBACK_METHOD = "fallback"
    }

    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    override fun getServer(): List<Server> {
        return serverPort.getServer()
    }

    private fun fallback(ex: Exception): List<Server> {
        logger.info("Circuit is OPEN and fallback has been called.")
        return emptyList()
    }
}