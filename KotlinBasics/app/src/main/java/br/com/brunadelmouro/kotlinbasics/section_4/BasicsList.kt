package br.com.brunadelmouro.kotlinbasics.section_4

fun main() {

    // immutable list
    val shoppingList = listOf("RAM", "PROCESSOR")

    println(shoppingList)

    // mutable list
    val shoppingListMutable = mutableListOf("RAM", "PROCESSOR")
    shoppingListMutable.add("SCREEN")
    shoppingListMutable.remove("RAM")

    println(shoppingListMutable)
}