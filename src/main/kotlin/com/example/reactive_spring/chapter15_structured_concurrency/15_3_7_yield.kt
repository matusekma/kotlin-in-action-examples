package com.example.reactive_spring.chapter15_structured_concurrency

import com.example.reactive_spring.log
import kotlinx.coroutines.*

suspend fun doCpuHeavyWork2(): Int {
    log("I'm doing work!")
    var counter = 0
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() < startTime + 500) {
        counter++
        yield()
    }
    return counter
}

fun main() {
    runBlocking {
        launch {
            repeat(3) {
                println(1)
                doCpuHeavyWork2()
            }
        }
        launch {
            repeat(3) {
                doCpuHeavyWork2()
            }
        }
    }
}