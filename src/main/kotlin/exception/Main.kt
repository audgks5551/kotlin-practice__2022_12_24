package exception

fun main() {
    // try catch 강제 안함
    Thread.sleep(1)

    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("에러 발생!")
    } finally {
        println("finally 실행!")
    }

    // try catch 도 표현식 형태로 가능
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생!")
    }
    println(a)

    // 예외 발생
    // throw Exception("예외 발생!")

    val b: String? = null
    val c = b ?: failFast("예외 발생!")
    println(c.length)

}

// Noting 반환을 선언해주면 이후에 출력되지 않는 실행문들을 표시해줌
fun failFast(message: String) : Nothing {
    throw IllegalArgumentException(message)
}