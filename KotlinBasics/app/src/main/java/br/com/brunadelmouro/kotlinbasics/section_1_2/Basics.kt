package br.com.brunadelmouro.kotlinbasics.section_1_2

fun main() {
    println("Hello World! I'm Bruna and I'm learning Kotlin in 2024.")

    // variables
    val numberOne = 1
    // numberOne = 2 -> not allowed, because val is a IMMUTABLE

    var myAge = 21
    myAge = 22 // -> allowed, because var is a MUTABLE

    println("My age is $myAge.")

    var byteType: Byte = 34
    var longType: Long = 34

    var pi = 3.14f
    println(pi)

    pi = 3.1445949505f
    println(pi)

    println("oi".plus(" Bruna"))
}