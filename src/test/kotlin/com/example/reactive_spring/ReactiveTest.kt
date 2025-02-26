package com.example.reactive_spring

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier


class TakeTest {
    @Test
    fun take() {
        val count = 10L
        val take = range().take(count)
        StepVerifier.create(take).expectNextCount(count).verifyComplete()
    }

    @Test
    fun takeUntil() {
        val count = 50
        val take = range().takeUntil { i -> i == (count - 1) }
        StepVerifier.create(take).expectNextCount(count.toLong()).verifyComplete()
    }

    private fun range(): Flux<Int> {
        return Flux.range(0, 1000)
    }
}