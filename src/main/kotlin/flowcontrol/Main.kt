package flowcontrol

fun main() {
    val age: Int = 10

    // if 문에서 값을 반환할 수 있다.
    // 자바에서는 String str = ""; 을 선언한 후에 str 객체에 값을 넣어야 함
    val str = if (age > 10) {
        "성인"
    } else {
        "아이"
    }
    println(str)
    println("=============")

    val a = 1
    val b = 2
    val c = if (b > a) b else a

    // switch == when
    // when 문 또한 if 문과 같이 값을 리턴받을 수 있다
    val day = 2
    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타"
    }
    println(result)
    println("=============")

    when (getColor()) {
        Color.RED -> println("red")
        Color.GREEN -> println("green")
        else -> println("blue")
    }
    println("=============")

    when (getNumber()) {
        0, 1 -> println("0 or 1 (O)")
        else -> println("0 or 1 (X)")
    }
    println("=============")

    // for 문
    // 범위 연산자 == 0 .. 3 == (0 <= i <= 3)
    for (i in 0 .. 3) {
        println(i)
    }
    println("=============")

    // 범위 연산자 == 0 until 3 == (0 <= i < 3)
    for (i in 0 until 3) {
        println(i)
    }
    println("=============")

    // step 은 2씩 증가
    for (i in 0 .. 6 step 2) {
        println(i)
    }
    println("=============")

    // downTo 는 왼쪽에서 오른쪽으로 감소
    for (i in 3 downTo 1) {
        println(i)
    }
    println("=============")

    val numbers: Array<Int> = arrayOf(1, 2, 3)

    for (i in numbers) {
        println(i)
    }
    println("=============")

    // while 은 기존의 java while 문과 같다
    var x = 5

    while (x > 0) {
        println(x)
        x--
    }
}

enum class Color {
    RED, GREEN, BLUE
}

fun getColor() = Color.RED

fun getNumber() = 2