package pairandDestructuring

// f((1, 3)) = 1 + 3 = 4
// f(1, 3) = 1 + 3 = 4

// 이미 제공된 Pair 객체 묘사
data class Tuple(val a: Int, val b: Int)

// Pair 는 불변
fun plus(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {
    val plus = plus(Pair(1, 3))
    println(plus)

    val pair = Pair("A", 1)
    // 컴파일 오류 (pair 는 불변이기 때문에)
    /*
        pair.first = "8"
     */
    val newPair = pair.copy(first = "B")
    println(newPair)

    val second = newPair.component2()
    println(second)

    val list = newPair.toList() // immutableList 제공
    println(list)

    // Triple 는 불변 객체
    val triple = Triple("A", "B", "C")
    println(triple)
    triple.first
    triple.second
    triple.third

    val newTriple = triple.copy(third = "D")
    println(newTriple)

    println(newTriple.component3())

    // 구조 분해 할당
    val (a: String, b: String, c: String) = newTriple
    println("$a, $b, $c")

    val list3 = newTriple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")

    // list 는 component 를 총 5개만 지원
    list3.component1()
    list3.component2()
    list3.component3()
//    list3.component4()
//    list3.component5()

    val map =  mutableMapOf("이상훈" to "개발자")
    for ( (key, value) in map ) {
        println("${key}의 직업은 $value")
    }
}