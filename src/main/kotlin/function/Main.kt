package function

// 기본 함수 정의
fun sum(a: Int, b: Int) : Int {
    return a + b
}

// 몸통이 없이 식으로 표현 가능
fun sum2(a: Int, b: Int) : Int = a + b

// 몸통없이 식으로 표현할 때 반환타입 없어도 가능
fun sum3(a: Int, b: Int) = a + b

// 그러나 몸통이 있는 경우 반환타입을 명시해주어야 함
/*
    // 컴파일 오류
    fun sum4(a: Int, b: Int) {
        return a + b
    }
 */
fun sum4(a: Int, b: Int) : Int {
    return a + b
}

// 반환이 없는 경우에 반환타입을 명시하지 않을 경우 Unit 타입임
fun printSum(a: Int, b: Int) : Unit {
    println("$a + $b + ${a + b}")
}

// 매개변수에 디폴트값 선언 가능
// null check 일 경우만 디폴트값 적용됨
fun greeting(message: String = "안녕하세요!!") {
    println(message)
}

// named argument 를 사용하여 가독성 향상
fun log(level: String = "INFO", message: String) {
    println("[$level]$message")
}

fun main() {
    // greeting 함수 예시
    greeting() // 안녕하세요!!
    greeting("hi") // hi

    // log 함수 예시
    log(message = "인포 로그")
    log(level = "DEBUG", "디버그 로그")
    log("WARN", "워닝 로그")
    log(level = "ERROR", message = "에러 로그")
}