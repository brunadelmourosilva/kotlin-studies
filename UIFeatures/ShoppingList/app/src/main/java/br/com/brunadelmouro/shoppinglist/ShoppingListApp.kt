package br.com.brunadelmouro.shoppinglist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ShoppingList() {

    var itemList by remember { mutableStateOf(listOf<Item>()) }
    var showDialogBox by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    )
    {
        Button(
            onClick = { showDialogBox = true },
            modifier = Modifier.align(Alignment.CenterHorizontally))
        {
            Text(text = "Add Item")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            items(itemList) {

                item ->
                    if(item.isEditing) {
                        ShoppingEditItem(item = item, onEditComplete =
                        {
                            editedName, editedQuantity ->
                            itemList = itemList.map { it.copy(isEditing = false)} //copie tudo do item, mas só altere o campo isEditing
                            val editedItem = itemList.find { it.id == item.id }
                            editedItem?.let {
                                it.name = editedName
                                it.quantity = editedQuantity
                            }
                        })
                    } else {
                        ShoppingItemList(item = item, onEditClick = {
                            itemList = itemList.map { it.copy(isEditing = it.id == item.id) }
                        }, onDeleteClick = {
                            itemList = itemList - item
                        })
                    }
            }
        }
    }

    if(showDialogBox) {
        AlertDialog(
            onDismissRequest = { showDialogBox = false },
            title = { Text(text = "Add Shopping Item") },
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName = it},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                        )

                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = { itemQuantity = it},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        if(itemName.isNotBlank()) {
                            val newItem = Item(itemList.size + 1, itemName, itemQuantity.toInt())
                            itemList = itemList + newItem

                            showDialogBox = false
                            itemName = ""
                        }
                    }) {
                        Text(text = "Add")
                    }
                }
            })
    }
}

@Composable
fun ShoppingItemList(item: Item, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {

    // box com name e quantity
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(border = BorderStroke(2.dp, Color(0xFF536DFE)), shape = RoundedCornerShape(20)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = item.name)

        Text(
            modifier = Modifier.padding(8.dp),
            text = "Qty: ${item.quantity}")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }

            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}

@Composable
fun ShoppingEditItem(item: Item, onEditComplete: (String, Int) -> Unit) {

    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            BasicTextField(
                value = editedName,
                onValueChange = {editedName = it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )

            BasicTextField(
                value = editedQuantity,
                onValueChange = {editedQuantity = it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
        }

        Button(onClick = {
            isEditing = false
            onEditComplete(editedName, editedQuantity.toIntOrNull() ?: 1) //converte valor de BasicTextField para Int(salvar na classe de Item)
        }) {
            Text(text = "Save")
        }
    }
}