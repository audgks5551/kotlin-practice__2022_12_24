package exception

fun getStr(): Nothing = throw Exception("예외 발생 기본값으로 초기화")

fun main() {
    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본값"
    }

    val result2 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"
        }

    val result3 = runCatching { "성공" }
        .getOrNull()

    val result4: Throwable? = runCatching { getStr() }
        .exceptionOrNull()

    val result5 = runCatching { getStr() }
        .getOrDefault("기본 값")

    val result6 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본 값"
        }

    val result7: String = runCatching { "기본값" }
        .getOrThrow()

    val result8: String = runCatching { "안녕" }
        .map {
            "${it}하세요"
        }.getOrThrow()

    val result9: String = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }.getOrDefault("기본 값")

    val result10 = runCatching { getStr() }
        .recover { "복구" }
        .getOrNull()

    val result11 = runCatching { getStr() }
        .recoverCatching { throw Exception("예외") }
        .getOrDefault("복구")

    println(result)
    println(result2)
    println(result3)
    result4?.let {
        println(it.message)
//        throw it
    }
    println(result5)
    println(result6)
    println(result7)
    println(result8)
    println(result9)
    println(result10)
    println(result11)
}