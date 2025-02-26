package com.example.reactive_spring.chapter15_structured_concurrency

import com.example.reactive_spring.log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

fun main() = runBlocking {
    val job = launch {
        log("A")
        delay(500.milliseconds) // #1 only suspension point where it can be cancelled
        log("B")
        log("C")
    }

    delay(510.milliseconds)
    job.cancel()
}