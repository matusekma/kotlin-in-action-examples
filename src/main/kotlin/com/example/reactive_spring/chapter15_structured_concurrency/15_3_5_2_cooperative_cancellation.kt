package com.example.reactive_spring.chapter15_structured_concurrency

import com.example.reactive_spring.log
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

suspend fun doCpuHeavyWork1(): Int {
    log("I'm doing work!")
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++ // #1
        delay(100.milliseconds) // suspension point
    }
    return counter
}

fun main() {
    runBlocking {
        withContext(Dispatchers.Default) {
            val myJob = launch {
                repeat(5) {
                    doCpuHeavyWork1()
                }
            }
            delay(600.milliseconds)
            myJob.cancel()
        }
    }
}