package scopefunction

class DatabaseClient {
    var url: String? = null
    var username: String? = null
    var password: String? = null

    // DB에 접속하고 Boolean 결과를 반환
    fun connect(): Boolean {
        println("DB 접속 중 ...")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }

    override fun toString(): String {
        return "DatabaseClient(url=$url, username=$username, password=$password)"
    }
}

fun main() {

    val config = DatabaseClient()
    config.url = "localhost:3306"
    config.username = "mysql"
    config.password = "1234"
    val connected1 = config.connect()


    // 위와 동일 구문
    // 마지막 리턴값 반환
    val connected2: Boolean = DatabaseClient().run {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }

    // 위와 동일 구문
    // 마지막 리턴값 반환
    val connected3: Boolean = DatabaseClient().let {
        it.url = "localhost:3306"
        it.username = "mysql"
        it.password = "1234"
        it.connect()
    }

    // 마지막 리턴값 반환
    val connected4: Boolean = with(DatabaseClient()) {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }

    // 해당 객체를 반환
    val client: DatabaseClient = DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }

    println(client)
    val connect = client.connect().run {
        println(this)
    }

    println(connected1)
    println(connected2)
    println(connected3)
    println(connected4)
}