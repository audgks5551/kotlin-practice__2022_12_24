package nonblocking

import java.util.concurrent.CompletableFuture

fun main() {
    // 비동기 처리
    // non-blocking 방식
    val completableFuture = CompletableFuture.supplyAsync {
        Thread.sleep(2000)
        sum(100, 200)
    }

    println("계산 시작")
    completableFuture.thenApplyAsync(::println)

    while (!completableFuture.isDone) {
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다")
    }
    println("계산 종료")
}