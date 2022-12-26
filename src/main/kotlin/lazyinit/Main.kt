package lazyinit

class HelloBot {
    // by lazy 는 정확히 한번만 수행됨
    // 멀티스레드 환경에서도 안전하게 실행됨
    // 싱글 스레드 환경에서는 LazyThreadSafetyMode.NONE
    // 멀티 스레드 환경에서는 LazyThreadSafetyMode.SYNCHRONIZED (생략 가능)
    val greeting: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("초기화 로직 수행")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

class LateInit {
    lateinit var text: String

    // 외부에서 init 가 되어있는지 확인할 때
    val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
        if (this::text.isInitialized) {
            println("초기화됨")
            println(text)
        } else {
            text = "late 안녕하세요"
        }
    }
}

fun main() {
    val helloBot = HelloBot()

    // ...
    // ...
    for (i in 1 .. 5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }

    val test = LateInit()
    test.printText()
}