package com.akshay8700.navigationexamplebyak

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String ,
                 goToFirstScreen:()->Unit,
                 goToThirdScreen:()->Unit
) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This is second screen",
            fontSize = 16.sp)
        Text(text = "Welcome to second screen, First Screen MSG:$name")
        Button(onClick = { goToFirstScreen() }) {
            Text(text = "Go to first screen",
                fontSize = 16.sp)
        }
        Button(onClick = { goToThirdScreen() }) {
            Text(text = "Go to third screen",
                fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondePreview() {
    SecondScreen("Hello second screen", {}, {})
}