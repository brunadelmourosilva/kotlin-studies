package br.com.brunadelmouro.mvvmarchitecture

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// todo one functions of the MVVM is maintain the object's state
// todo so, e.g: if I increment the button for some times, and after
// todo rotate the screen, then, the state of the counter will not
// todo be lost. The value will continue the same.
class CounterViewModel : ViewModel() {

    // todo _ indicate as a good practice that this variable is private
    private var _count  = mutableStateOf(0)

    // todo expose the variable _count to become public
    val count: MutableState<Int> = _count

    fun increment() {
        _count.value++;
    }

    fun decrement() {
        _count.value -= _count.value;
    }

}