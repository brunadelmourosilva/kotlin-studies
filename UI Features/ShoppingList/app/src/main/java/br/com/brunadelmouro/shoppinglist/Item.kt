package br.com.brunadelmouro.shoppinglist

data class Item(val id: Int, var name: String, var quantity: Int, var isEditing: Boolean = false)
