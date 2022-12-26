package coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    doSomething()
}

fun printHello() = println("hello")

// suspend fun : 일시중단이 가능한 함수
suspend fun doSomething() = coroutineScope {

    launch {
        delay(200)
        println("world!")
    }

    launch {
        printHello()
    }

}