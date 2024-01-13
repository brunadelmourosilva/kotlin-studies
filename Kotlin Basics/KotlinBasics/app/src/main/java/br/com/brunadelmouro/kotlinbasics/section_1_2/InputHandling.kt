package br.com.brunadelmouro.kotlinbasics.section_1_2

fun main() {

    print("Please enter a number: ")
    var inputString = readln()

    var inputInteger = inputString.toInt()

    val multiplier = 5

    println("Result of operation is: " + inputInteger * multiplier)
}