package br.com.brunadelmouro.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class RecipeState(
    val loading: Boolean = true,
    val list: List<Category> = emptyList(),
    val error: String? = null
)

class MainViewModel : ViewModel() {

    private val _categorieState = mutableStateOf(RecipeState())

    // TODO: exposing the _categorieState variable
    val categoriesState: State<RecipeState> = _categorieState

    // TODO: initialize the coroutine
    // TODO: it's like a static block in Java
    // TODO: So when the app start, the first code executed, is to fetch the categories
    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        // TODO: run async functions that uses 'suspend' keyword
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()

                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false, // TODO: when the response is received, then it's not necessary loading the page
                    error = null
                )

            } catch (e: Exception) {
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }
}