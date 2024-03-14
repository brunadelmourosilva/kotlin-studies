package br.com.brunadelmouro

class Daughter : Mother(), Skills {

    override fun eyes() {
        //super.eyes()
        println("I'm daughter and I have blue eyes.")
    }

    override fun run() {
        super.run()
        println("I'm daughter and my skill as a runner was increased.")
    }
}