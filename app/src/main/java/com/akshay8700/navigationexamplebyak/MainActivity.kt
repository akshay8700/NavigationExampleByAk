package com.akshay8700.navigationexamplebyak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akshay8700.navigationexamplebyak.ui.theme.NavigationExampleByAkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MyApp()
            }
        }
    }
}

// Function for managing diffirent screens
@Composable
fun MyApp(){
    // Creating NavHostController actually we need this for controlling NavHost function
    val navController = rememberNavController()

    // NavHost function for managing different screens,
    // start Destination means which Screen he should start first
    NavHost(navController = navController, startDestination = "firstscreen"){
        /* composable function given by specialy for NavHost
         NavController means navigation controller will control this composable functions
         We are assuming every composable as a different screen, So navController is navigating to all
         those composables by their name for example here navController.navigate("secondscreen/$name") we are navigating to secondscreen composable function
         By the way this navigation controller is not directly calling actual screen funtion he is calling his own composable fun
         and that composable fun is actually calling that real screen function*/
        composable("firstscreen"){
            FirstScreen {name ->
                navController.navigate("secondscreen/$name")
            }
        }
        composable(route = "secondscreen/{name}"){
            // getting name string given by FirstScreen function and sending that name string to SecondScreen first parameter
            val name = it.arguments?.getString("name") ?: "no name"
            SecondScreen(name,
                goToFirstScreen = {
                navController.navigate("firstscreen")
            }, goToThirdScreen = {
                navController.navigate("thirdscreen")
            })
        }
        composable(route = "thirdscreen"){
            ThirdScreen {
                navController.navigate("firstscreen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MyApp()
    }
}