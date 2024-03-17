package br.com.brunadelmouro.mvvmarchitecture;

data class CounterModel(var count: Int)

//todo MODEL
class CounterRepository() {
    private var _counter = CounterModel(0)

    fun getCounter() = _counter

    fun incrementCounter() {
        _counter.count++
    }

    fun decrementCounter() {
        _counter.count--
    }
}