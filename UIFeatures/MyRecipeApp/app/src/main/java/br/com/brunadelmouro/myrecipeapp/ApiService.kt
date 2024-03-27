package br.com.brunadelmouro.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// TODO: defining the default URL and setting up the converter to kotlin objects
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()).build()

// TODO: creating the retrofit definition and exposing it to be used in other classes
val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {

    // TODO: 'suspend' keyword is useful to run tasks asynchronous, in separated threads
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

}