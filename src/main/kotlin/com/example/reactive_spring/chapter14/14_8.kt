package com.example.reactive_spring.chapter14

import com.example.reactive_spring.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        log("Doing some work")
        launch(Dispatchers.Default) { // #1
            log("Doing some background work")
        }
    }
}