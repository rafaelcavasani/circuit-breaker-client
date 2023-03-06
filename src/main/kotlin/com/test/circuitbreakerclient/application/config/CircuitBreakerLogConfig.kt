package com.test.circuitbreakerclient.application.config

import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.core.registry.EntryAddedEvent
import io.github.resilience4j.core.registry.EntryRemovedEvent
import io.github.resilience4j.core.registry.EntryReplacedEvent
import io.github.resilience4j.core.registry.RegistryEventConsumer
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CircuitBreakerLogConfig {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun cbLog(): RegistryEventConsumer<CircuitBreaker> {
        return object : RegistryEventConsumer<CircuitBreaker> {
            override fun onEntryAddedEvent(entryAddedEvent: EntryAddedEvent<CircuitBreaker>) {
                entryAddedEvent.addedEntry.eventPublisher.onStateTransition {
                    logger.info("Added entry -> $it")
                }
            }

            override fun onEntryRemovedEvent(entryRemoveEvent: EntryRemovedEvent<CircuitBreaker>) {
                entryRemoveEvent.removedEntry.eventPublisher.onStateTransition {
                    logger.info("Removed entry -> $it")
                }
            }

            override fun onEntryReplacedEvent(entryReplacedEvent: EntryReplacedEvent<CircuitBreaker>) {
                entryReplacedEvent.newEntry.eventPublisher.onStateTransition {
                    logger.info("New entry -> $it")
                }
            }
        }
    }

}