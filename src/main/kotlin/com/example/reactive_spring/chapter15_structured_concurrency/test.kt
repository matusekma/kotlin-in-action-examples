package com.example.reactive_spring.chapter15_structured_concurrency

import com.example.reactive_spring.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds


fun main() {

    runBlocking {
        try {
            supervisorScope {  }
            with(CoroutineScope(SupervisorJob())) {
                launch {
                    throw RuntimeException("Crash!")
                }
                launch {
                    delay(500)
                    println("Done!")
                }
            }
            delay(5000)
        } catch (e: Exception) {
            delay(5000)
            println("Caught exception: $e")
        }
    }
    println("finished")

}
