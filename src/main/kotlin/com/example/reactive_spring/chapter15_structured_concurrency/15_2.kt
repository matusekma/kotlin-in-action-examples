package com.example.reactive_spring.chapter15_structured_concurrency

import com.example.reactive_spring.log
import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

suspend fun generateValue(): Int {
    delay(500.milliseconds)
    return Random.nextInt(0, 10)
}

suspend fun computeSum() { // #1
    log("Computing a sum...")
    val sum = coroutineScope { // #2
        val a = async { generateValue() }
        val b = async { generateValue() }
        a.await() + b.await() // #3
    }
    log("Sum is $sum")
}

fun main() = runBlocking {
    computeSum()
}
