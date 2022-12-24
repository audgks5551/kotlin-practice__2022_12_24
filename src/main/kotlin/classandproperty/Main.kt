package classandproperty

// constructor(val name: String) == (val name: String)
// var 키워드로 선언할 경우 getter, setter 자동 생성
// val 키워드로 선언할 경우 getter 만 생성
// 코틀린의 property 는 매우 객체지향적이다
class Coffee1 constructor(val name: String, val price: Int,) {}
class Coffee2 (
    var name: String = "기본값",
    var price: Int = 0, // 후행 쉼표 사용 가능 (강력 추천, 깃허브 commit 볼 때 유용)
    var iced: Boolean = false,
) {
    // custom property
    val brand: String
        get() {
            return "스타벅스"
        }

    var quantity: Int = 0
        set(value) {
            if (value > 0) { // 수량이 0 이상인 경우에만 할당
                field = value // field == 식별자 ( ex) quantity )
                // field 말고 quantity 로 작성시 무한 루프
            }
        }
}

class EmptyClass

fun main() {
    val coffee = Coffee2()
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true

    if (coffee.iced) {
        println("아이스 커피")
    }

    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price}, 수량은 ${coffee.quantity}")
}