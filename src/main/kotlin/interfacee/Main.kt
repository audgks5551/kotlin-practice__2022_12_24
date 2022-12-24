package interfacee

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

interface Cart : Wheel {

    // abstract property
    var coin: Int

    // default property
    val weight: String
        get() = "20KG"

    // abstract method
    fun add(product: Product)

    // default method
    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다")
        }
    }

    // default method
    fun printId() = println("1234")
}

interface Order {
    // default method
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다")
    }

    // default method
    fun printId() = println("5678")
}

// 복수 개의 인터페이스 구현 가능
class MyCart(override var coin: Int) : Cart, Order {
    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가되었습니다")

        // 주문하기
        super<Order>.add(product)
    }

    // 인터페이스 default 메서드 이름이 동일할 경우에는 override 를 해야함
    // super 키워드를 사용하여 기존의 작성된 인터페이스 default 메서드에 접근 가능
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }

    override fun roll() {
        println("카트가 굴러갑니다")
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()

    cart.roll()

    cart.add(Product(name = "장난감", price = 1000))

    cart.printId()
}