package com.example.reactive_spring.chapter15_structured_concurrency

import com.example.reactive_spring.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    runBlocking {
        val launchedJob = launch { // #1
            log("I'm launched!")
            delay(1000.milliseconds)
            log("I'm done!")
            coroutineContext.ensureActive()
        }
        val asyncDeferred = async { // #2
            log("I'm async")
            delay(1000.milliseconds)
            log("I'm done!")
        }
        delay(200.milliseconds)
        launchedJob.cancel() // #3
        asyncDeferred.cancel() // #3
    }
}