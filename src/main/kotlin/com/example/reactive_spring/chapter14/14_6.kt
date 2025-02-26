package com.example.reactive_spring.chapter14

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

suspend fun doSomethingSlowly() {
    delay(500.milliseconds) // #1
    println("I'm done")
}

fun main() = runBlocking {
    doSomethingSlowly()
}