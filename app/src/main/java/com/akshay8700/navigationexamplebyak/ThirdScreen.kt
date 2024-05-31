package com.akshay8700.navigationexamplebyak

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ThirdScreen(modifier: Modifier = Modifier, goToFirstScreen: ()->Unit) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to 3rd screen")
        Button(onClick = { goToFirstScreen() }) {
            Text(text = "Go to the 1st screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ThirdScreen {
            {}
        }
    }
}