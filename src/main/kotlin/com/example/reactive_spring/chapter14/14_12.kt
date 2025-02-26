package com.example.reactive_spring.chapter14

import com.example.reactive_spring.log
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

suspend fun introspect() {
    log(coroutineContext) // #1
}

fun main() {
    runBlocking {
        introspect()
    }
}