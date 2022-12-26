package jeneric

class MyGenerics<out T>(val t: T) {}

class Bag<T> {
    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>
    ) {
        to.addAll(from)
    }
}

fun main() {
    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 type argument 를 제공함
    val generics = MyGenerics<String>("hello")

    // type argument 가 추론되어 생략 가능
    val generics2 = MyGenerics("hello")

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()

    // type argument 를 생성자에서 추가
    val list2 = mutableListOf<String>()

    val list3 : List<*> = listOf<String>("테스트")
    val list4 : List<*> = listOf<Int>(1, 2, 3, 4)

    // PECS(Producer-Extends, Consumer-Super)
    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    // 반공변성은 자바 제네릭의 super 코틀린에선 in
    val generics3 = MyGenerics<String>("hello")
    val charGenerics: MyGenerics<CharSequence> = generics3

    val bag = Bag<String>()

    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("1"))

}