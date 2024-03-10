package br.com.brunadelmouro.kotlinbasics.section_7

// TODO: https://tutorials.eu/exploring-more-advanced-ui-components-day-7-android-14-masterclass/
fun main() {

    // map function
    var numbersList = listOf<Int>(1, 2, 3, 5)

    numbersList = numbersList.map { number -> number * 2 }

    println(numbersList)

    // copy function
    val bookOne = Book("Book One", "Bruna",2023)
    val bookTwo = bookOne.copy(title = "Book Two", publishedYear = 2024) // it doesn't modify the authorName value

    println("Book One: $bookOne")
    println("Book Two: $bookTwo")

    // let function and nullable strings

    // nullable
    var nullableString: String? = "Hi"
    nullableString = null // it can receive a null value because the variable is marked with ?

    // let function - it will execute the block if the variable is not null
    nullableString?.let {
        println("I will not be executed because i'm a null value")
    }

    var name: String? = "Bruna"
    name?.let { println("My name is ${name}.") }

    name = null
    name?.let { println("My name is ${name}.") }

    // find function - finds the first found
    val nameWithB = listOf("Alex", "Bruna", "Beatriz")
                        .find { name -> name.startsWith("B") }

    println(nameWithB)

    // filter function
    val namesWithB = listOf("Alex", "Bruna", "Beatriz")
        .filter { name -> name.startsWith("B") }
        .forEach { print("$it ") }
}