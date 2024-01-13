package br.com.brunadelmouro.kotlinbasics.section_3

class BookClass(
    var title: String = "Unknown",
    val author: String = "Anonymous",
    var yearPublished: Int = 2024
){

    // manual implementation
//    override fun toString(): String {
//        return "BookClass(title='$title', author='$author', yearPublished=$yearPublished)"
//    }
}

fun main() {

    val myBook = BookClass()
    println("Book ${myBook.title}, ${myBook.author}, ${myBook.yearPublished}")

    val customBook = BookClass("Custom", "Bruna", 2023)
    println("Book ${customBook.title}, ${customBook.author}, ${customBook.yearPublished}")

    //set a new value to a mutable properties
    customBook.title = "I've changed!"
    println("Book ${customBook.title}, ${customBook.author}, ${customBook.yearPublished}")
}