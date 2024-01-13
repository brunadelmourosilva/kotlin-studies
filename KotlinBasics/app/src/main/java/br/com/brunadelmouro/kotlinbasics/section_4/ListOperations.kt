package br.com.brunadelmouro.kotlinbasics.section_4

fun main() {

    val fruitsList = mutableListOf("Melon", "Strawberry", "Banana")
    fruitsList.add("Apple")
    fruitsList.remove("Melon")
    println(fruitsList)

    val hasGuava = fruitsList.contains("Guava")
    println("Has guava: $hasGuava")

    // doc: https://kotlinlang.org/docs/control-flow.html#for-loops
    for (i in fruitsList) {
        println(i)
    }

    for (i in 0 until fruitsList.size) {
        println(fruitsList[i] + " -> " + i)
    }

    // doc: https://kotlinlang.org/docs/lambdas.html#underscore-for-unused-variables
    fruitsList.forEach{fruit -> println(fruit) }
}