package scopefunction

fun main() {
    val str: String? = "안녕"

    val result: Int? = str?.let {
        println(it)

        // 가독성이 좋지 못하므로 if else 를 사용하는 것이 유리
        val abc: String? = "abc"
        abc?.let {

            val def: String? = "def"

            def?.let {
                println("abcdef 가 null 이 아님")
            }
        }

        1234
    }

    println(result)
}