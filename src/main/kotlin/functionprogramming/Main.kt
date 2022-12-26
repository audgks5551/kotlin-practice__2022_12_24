package functionprogramming

fun main() {

    val list = mutableListOf(printHello)

    val func: () -> Unit = list[0]
    func()

    call(printHello)

    // 컴파일 오류
    // val list2 = mutableListOf(printNo)
    // call(printNo)

    val result: Int = plus(1, 3, 5)
    println(result)

    val list3 = listOf("a", "b", "c")
    val printStr : (String) -> Unit = { println(it) }

    forEachStr(list3, printStr)

    list3.forEach {
        println(it)
    }

    val upperCase: (String) -> String = { it.uppercase() }
    println(list3.map(upperCase))

    val func2 = outerFunc()
    func2()

    val func3 = outerFunc2()
    func3()
}

fun outerFunc() : () -> Unit {
    return fun() {
        println("이것은 익명함수!")
    }
}

fun outerFunc2() : () -> Unit {
    return {
        println("이것은 익명함수!")
    }
}

fun outerFunc3() : () -> Unit = { println("이것은 익명함수!") }

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

// 최대한 생략한 람다식
val sum2 = { x: Int, y: Int -> x + y }

fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

val printMessage: (String) -> Unit = { message: String -> println(message) }

val printMessage2: (String) -> Unit = { message -> println(message) }

val printMessage3: (String) -> Unit = { println(it) }

val plus : (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

fun printHello2() {}

val printHello : () -> Unit = { println("Hello") }

val func: () -> String = { "문자열" }

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

fun printNo() = println("No!")