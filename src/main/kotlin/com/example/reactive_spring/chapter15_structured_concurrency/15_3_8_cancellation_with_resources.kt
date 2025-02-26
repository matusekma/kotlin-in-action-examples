package com.example.reactive_spring.chapter15_structured_concurrency

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

class DatabaseConnection : AutoCloseable {
    fun write(s: String) = println("writing $s!")
    override fun close() {
        println("Closing!")
    }
}

fun main() {
    runBlocking {
        val dbTask = launch {
            val db = DatabaseConnection()
            db.use { db ->
                delay(500.milliseconds)
                db.write("I love coroutines!")
            }
        }
        delay(200.milliseconds)
        dbTask.cancel()
    }
    println("I leaked a resource!")
}