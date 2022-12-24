package nullpointexception

fun main() {
    // 컴파일 오류
    // 기본적으로 모든 변수는 null 허용하지 않는다
    /*
        val a: String = null

        var b: String = "aabbcc"
        b = null
     */

    // null 허용시 ? 로 타입 뒤에 적어주면 됨
    var a: String? = null
    println(a?.length) // null point exception 이 없이 null 출력됨
    println("========")

    // if 문을 통해 null 상황 제거
    val b: Int = if (a != null) a.length else 0
    println(b)
    println("========")

    // 엘비스 연산자 사용됨
    // ?: 의 왼쪽이 null 인 경우에 오른쪽을 반환 및 실행
    val c = a?.length ?: 0
    println(c)
    println("========")

    // java -> kotlin
    // 1.
    val nullableStr = getNullStr()
    println(nullableStr?.length ?: 0)
    println("========")

    // 2.
    val length = getLengthIfNotNull(null)
    println(length)

    // 코틀린에서 null point exception 발생할 수 있음
    // 줄여주는 것 일뿐
    val d: String? = null
    // null point exception 발생
    /*
        val e = d!!.length
        println(e)
     */
    // 기존의 자바코드를 가져올 때도 null checking 불가능하기에 안전연산자를 사용해야함
    /*
        println(Java_NullSafety.getNullStr().length)
     */
    println(Java_NullSafety.getNullStr()?.length ?: 0)

}

fun getNullStr() : String? = null

fun getLengthIfNotNull(str: String?) : Int = str?.length ?: "null 경우 반환".length