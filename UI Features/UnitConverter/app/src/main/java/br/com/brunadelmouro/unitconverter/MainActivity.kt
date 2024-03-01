package br.com.brunadelmouro.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.brunadelmouro.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    val conversionFactor = remember { mutableDoubleStateOf(1.00) } //immutable
    val oConversionFactor = remember { mutableDoubleStateOf(1.00) } //immutable

    // text style
    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6550A1)
    )

    // in kotlin, you can use a function inside of a composable
    fun convertUnits() {
        // ?: Elvis operator
        val inputToDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputToDouble * conversionFactor.doubleValue * 100.0 / oConversionFactor.doubleValue).roundToInt() / 100

        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //all elements will be snacked below each other
        Text(text = "Unit Converter", style = customTextStyle)

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                //here goes what happen, when the value changes - todo o que é IT
                inputValue = it
                convertUnits()
            },
            label = {Text("Enter the value")})

        Spacer(modifier = Modifier.height(16.dp))

        Row {
//            var context = LocalContext.current
//            Button(onClick = {
//                Toast
//                    .makeText(context, "Thanks!", Toast.LENGTH_LONG)
//                    .show()
//            }) {
//                Text(text = "Click me!")
//            }
            Box {
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }

                // onDismissRequest -> if you click in the screen
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {

                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.doubleValue = 0.01
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text(text = "Meters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            conversionFactor.doubleValue = 1.0
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text(text = "Feet") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            conversionFactor.doubleValue = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Millimeters") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Millimeters"
                            conversionFactor.doubleValue = 0.001
                            convertUnits()
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }

                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.doubleValue = 0.01
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Meters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.doubleValue = 1.00
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Feet") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.doubleValue = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text(text = "Millimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Millimeters"
                            oConversionFactor.doubleValue = 0.001
                            convertUnits()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $outputValue $outputUnit", style = customTextStyle, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}