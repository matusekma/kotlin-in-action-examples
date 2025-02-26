package com.example.reactive_spring.chapter14

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(Dispatchers.Default) { // #1
            var x = 0
            repeat(10_000) {
                x++
            }
            println(x)
        }
    }
}