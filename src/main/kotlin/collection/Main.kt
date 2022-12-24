package collection

import java.util.*
import java.util.stream.Collectors

fun main() {
    // immutable
    val currencyList = listOf("달러", "유료", "원")
    // currencyList.add() 추가 불가능, 변경 불가능

    // mutable
    val mutableCurrencyList: MutableList<String> = mutableListOf<String>().apply {
        this.add("달러")
        add("유료")
        add("원")
    }
    mutableCurrencyList.add("파운드")

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2)

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    mutableNumberMap.put("two", 2)

    // 컬렉션 빌더
    // 컬렉션 빌더는 내부에선 mutable 반환은 immutable
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
        add(4)
    }
    // numberList.add(5) 추가 불가능, 변경 불가능

    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    // iterator
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("=================")

    for (currency in currencyList) println(currency)

    println("=================")

    currencyList.forEach {
        println(it)
    }

    println("=================")

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
    val upperList = mutableListOf<String>()

    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
    println(upperList)

    println("=================")

    val upperList2 = lowerList.map { it.uppercase() }
    println(upperList2)

    println("=================")

    // filter
    val filteredList = mutableListOf<String>()
    for (upperCase in upperList2) {
        if (upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }
    println(filteredList)

    println("=================")

    val filteredList2 = upperList2.filter { it == "A" || it == "B" } // kotlin
    val filteredList3 = upperList2.stream()
        .filter { it == "A" || it == "C" }
        .collect(Collectors.toList()) // java
    val filteredList4 = upperList2
        .asSequence()
        .filter { it == "A" || it == "B" }
        .toList()

    println(filteredList2)
    println(filteredList3)
    println(filteredList4)
}