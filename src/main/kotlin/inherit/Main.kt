package inherit

// 코틀린의 객체의 모든 조상은 Any
// 자바의 객체의 모든 조상은 Object
// 코틀린 객체는 기본적으로 상속 불가
// open 키워드를 통해 상속 허용함
// override 는 기본적으로 상속 허용됨 (final 키워드를 통해 막을 수 있음)
open class Dog {
    open var age: Int = 0
    open fun bark() {
        println("멍멍")
    }
}

open class Bulldog (
    final override var age: Int = 0
) : Dog() {

    override fun bark() {
        super.bark() // super 사용시 상위 클래스 접근 가능
        println("컹컹")
    }
}

class ChildBulldog : Bulldog() {
    override fun bark() {
        println("콩콩")
    }
}

// 추상 클래스
abstract class Developer {
    var name: String = "default"
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int) : Developer() {
    override fun code(language: String) {
        println("I code with $language")
    }
}

fun main() {
    val dog = Bulldog(age = 2)
    println(dog.age)
    dog.bark()

    val developer = BackendDeveloper(age = 27)
    println(developer.age)
    developer.code("Kotlin")
    println(developer.name)
}