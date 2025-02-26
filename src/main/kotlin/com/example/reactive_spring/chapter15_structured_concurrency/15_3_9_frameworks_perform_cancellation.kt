package com.example.reactive_spring.chapter15_structured_concurrency

// Android
//class MyViewModel : ViewModel() {
//    init {
//        viewModelScope.launch { // #1
//            while (true) {
//                println("Tick!")
//                delay(1000.milliseconds)
//            }
//        }
//    }
//}

// Ktor
//routing {
//    get("/") { // this: PipelineContext
//        launch { // #1
//            println("I'm doing some background work!")
//            delay(5000.milliseconds)
//            println("I'm done")
//        } }
//}

// Ktor application level scope
//routing { get("/") {
//    call.application.launch { // #1
//        println("I'm doing some background work!") delay(5000.milliseconds)
//        println("I'm done")
//    } }
//}