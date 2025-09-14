package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Greeting("Android")

                        // Aquí irás agregando los 3 componentes poco a poco
                        MyButtonExample()
                        MyCardExample()
                        MySnackbarExample()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// 1. Ejemplo de Button
@Composable
fun MyButtonExample() {
    Button(onClick = { }) {
        Text("Presióname")
    }
}

// 2. Ejemplo de Card
@Composable
fun MyCardExample() {
    Card(modifier = Modifier.padding(8.dp)) {
        Text("Soy una Card en Compose", modifier = Modifier.padding(16.dp))
    }
}

// 3. Ejemplo de Snackbar
@Composable
fun MySnackbarExample() {
    var showSnackbar by remember { mutableStateOf(true) }

    if (showSnackbar) {
        Snackbar(
            action = {
                TextButton(onClick = { showSnackbar = false }) {
                    Text("OK")
                }
            }
        ) {
            Text("Soy un Snackbar!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Column {
            Greeting("Android")
            MyButtonExample()
            MyCardExample()
            MySnackbarExample()
        }
    }
}
