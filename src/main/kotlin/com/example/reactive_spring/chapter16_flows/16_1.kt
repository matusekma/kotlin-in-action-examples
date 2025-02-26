package com.example.reactive_spring.chapter16_flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds
import com.example.reactive_spring.log

suspend fun createValues(): List<Int> {
    return buildList { // #1
        add(1)
        delay(1.seconds)
        add(2)
        delay(1.seconds)
        add(3)
        delay(1.seconds)
    }
}
fun main() = runBlocking {
    val list = createValues()
    list.forEach {
        log(it) // #2
    }
}