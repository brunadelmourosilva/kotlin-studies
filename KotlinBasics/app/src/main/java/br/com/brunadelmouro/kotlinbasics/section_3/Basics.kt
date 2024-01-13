package br.com.brunadelmouro.kotlinbasics.section_3

fun main() {

    println("Who is this coffee for?")
    val name = readln()

    val ret = askCoffeeDetails(name)
    println(ret)
}

fun askCoffeeDetails(name: String): String {

    do {
        println("How many spoons of sugar do you  want?")
        val sugarCount = readln().toInt()

        when (sugarCount) {
            0 -> {
                println("Coffee with no sugar for $name.")
            }
            1 -> {
                println("Coffee with $sugarCount spoon of sugar for $name.")
            }
            else -> {
                if(sugarCount < 0) {
                    println("Invalid input. Try again.")
                } else {
                    println("Coffee with $sugarCount spoons of sugar for $name.")
                }
            }
        }
    } while (sugarCount < 0)

    return "OK"
}