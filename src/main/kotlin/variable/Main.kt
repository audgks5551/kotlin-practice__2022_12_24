package variable

fun main(args: Array<String>) {
    // 변수타입 선언
    val a: Int = 1

    // 변수 타입 추론해줌
    // 변수 타입 선언 필수 아님
    val b = 1

    // 변수 선언 후 나중에 변수 값 설정 가능
    val c: Int
    c = 3
    println(c)
    // 그러나 변수 타입을 지정해주어야 가능
    // 컴파일 오류
    /*
        val d
        d = 4
     */

    // val = value = final = readOnly = 재할당 불가능
    val e: String = "hello"
    // 컴파일 오류
    /*
        e = "world"
     */

    // var = variable = 가변변수 = 재할당 가능
    var f: String = "hello"
    f = "world"

    x += 1
    println(x)
}

// 탑 레벨 방식 지원
var x = 5