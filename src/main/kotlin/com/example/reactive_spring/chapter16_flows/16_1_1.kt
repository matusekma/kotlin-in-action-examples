package com.example.reactive_spring.chapter16_flows

import com.example.reactive_spring.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.milliseconds

fun createValueFlow(): Flow<Int> {
    return flow {
        emit(1) // #1
        delay(1000.milliseconds)
        emit(2)
        delay(1000.milliseconds)
        emit(3)
        delay(1000.milliseconds)
    }
}
fun main() = runBlocking {
    val myFlowOfValues = createValueFlow()
    myFlowOfValues.collect {
        log(it)
    } // #2
}