package br.com.brunadelmouro.capitangame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// belongs to "by" keyword
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.brunadelmouro.capitangame.ui.theme.CapitanGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapitanGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CapitanGame()
                }
            }
        }
    }
}

@Composable
fun CapitanGame() {
    val treasuresFound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }

    // another way to declare a mutable state, it isn't necessary to declare the .value
    var stormOrTreasure by remember { mutableStateOf("") }

    val purpleButtonColor = ButtonDefaults.buttonColors(Color.Magenta)

    Column {
        Text(text = "Treasures found: ${treasuresFound.value}")
        Text(text = "Direction: ${direction.value}")
        Text(text = stormOrTreasure)

        Button(
            onClick = {
                direction.value = "East"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    stormOrTreasure = "Found a Treasure!"
                } else {
                    stormOrTreasure = "Storm Ahead!"
                }
            }, colors = purpleButtonColor
        ) {
            Text(text = "Sail East")
        }

        Button(onClick = {
            direction.value = "West"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure = "Found a Treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
            }
        }, colors = purpleButtonColor) {
            Text(text = "Sail West")
        }

        Button(onClick = {
            direction.value = "North"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure = "Found a Treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
            }
        }, colors = purpleButtonColor) {
            Text(text = "North East")
        }

        Button(onClick = {
            direction.value = "South"
            if (Random.nextBoolean()) {
                treasuresFound.value += 1
                stormOrTreasure = "Found a Treasure!"
            } else {
                stormOrTreasure = "Storm Ahead!"
            }
        }, colors = purpleButtonColor) {
            Text(text = "Sail South")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CapitanGameTheme {
        CapitanGame()
    }
}