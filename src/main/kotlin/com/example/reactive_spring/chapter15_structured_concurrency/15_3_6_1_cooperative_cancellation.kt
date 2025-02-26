package com.example.reactive_spring.chapter15_structured_concurrency

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    runBlocking {
        withContext(Dispatchers.Default) {
            val myJob = launch {
                repeat(5) {
                    doCpuHeavyWork()
                    if (!isActive) return@launch
                }
            }
            delay(600.milliseconds)
            myJob.cancel()
        }
    }
}