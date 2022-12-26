package scopefunction

fun main() {
    val str = "안녕하세요"

    // 확장함수가 아님
    val length: Int = with (str) {
       println("length = $length")

        length
    }

    println(length)
}