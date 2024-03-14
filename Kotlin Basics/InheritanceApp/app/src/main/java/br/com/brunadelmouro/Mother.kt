package br.com.brunadelmouro

// todo open allows to be extended
open class Mother {

    fun hair() {
        println("My hair is black.")
    }

    fun height() {
        println("I'm tall.")
    }

    // todo open allows to be override
    open fun eyes() {
        println("I have green eyes.")
    }
}