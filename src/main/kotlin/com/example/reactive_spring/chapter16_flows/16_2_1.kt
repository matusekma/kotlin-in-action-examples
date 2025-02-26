package com.example.reactive_spring.chapter16_flows

import com.example.reactive_spring.log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    runBlocking {
        val letters = flow {
            log("Emitting A!")
            emit("A") // #1
            delay(200.milliseconds)
            log("Emitting B!")
            emit("B")
        }
        letters.collect()
    }

}