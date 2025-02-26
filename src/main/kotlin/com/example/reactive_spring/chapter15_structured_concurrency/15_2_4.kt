package com.example.reactive_spring.chapter15_structured_concurrency

import com.example.reactive_spring.log
import kotlinx.coroutines.*

fun main() {
    runBlocking(Dispatchers.Default) {
        log(coroutineContext)
        launch {
            log(coroutineContext)
            launch(Dispatchers.IO + CoroutineName("mine")) {
                log(coroutineContext)
            }
        }
    }
}