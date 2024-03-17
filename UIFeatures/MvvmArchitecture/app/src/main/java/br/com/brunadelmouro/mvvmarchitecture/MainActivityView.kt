package br.com.brunadelmouro.mvvmarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.brunadelmouro.mvvmarchitecture.ui.theme.MvvmArchitectureTheme

//todo VIEW

class MainActivityView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // todo it's necessary to add the viewModel() dependency because the class CounterViewModel inherits from ViewModel
            val viewModel: CounterViewModel = viewModel()

            MvvmArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(viewModel: CounterViewModel) {

    // todo set the properties of the background screen
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // todo align buttons side by side
        Row {
            Button(onClick = { viewModel.increment() }) {
                Text(text = "Increment")
            }

            Button(onClick = { viewModel.decrement() }) {
                Text(text = "Decrement")
            }
        }

        // todo spacer
        Spacer(modifier = Modifier.height(16.dp))

        // todo text to show counter
        Text(
            text = "Counter: ${viewModel.count.value}",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MvvmArchitectureTheme {
        CounterApp(CounterViewModel())
    }
}