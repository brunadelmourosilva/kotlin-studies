package br.com.brunadelmouro.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.brunadelmouro.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyMainApp()
                }
            }
        }
    }
}

@Composable
fun MyMainApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstscreen") {
        composable("firstscreen") {
            FirstScreen {
                navController.navigate("secondscreen")
            }
        }

        composable("secondscreen") {
            SecondScreen(navigationToFirstScreen = { navController.navigate("firstscreen") },
                navigateToThirdScreen = { navController.navigate("thirdscreen") })
        }

        composable("thirdscreen") {
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}