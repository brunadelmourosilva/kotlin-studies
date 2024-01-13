package br.com.brunadelmouro.kotlinbasics.section_3

/* Data classes automatically generate several useful methods, such as toString(), equals(), hashCode(), and copy()
  a regular class in Kotlin is a more general-purpose class that you can use for various purposes,
  not just for holding data. You have to manually implement methods like toString(), equals(), hashCode() */
data class CoffeeDetailsDataClass(var sugarCount: Int, var name: String, var size: String)

fun main() {
    val coffeeDetails = CoffeeDetailsDataClass(1, "Bruna", "xxl")
}
