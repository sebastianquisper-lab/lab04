package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        CustomButton {}
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
fun CustomButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3700B3), // morado oscuro
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp), // bordes redondeados
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp
        )
    ) {
        Text(
            text = "Click Me 🚀",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
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
                    Text(
                        "CERRAR",
                        color = Color.Yellow,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            containerColor = Color(0xFF6200EE), // morado
            contentColor = Color.White,         // texto blanco
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Soy un Snackbar con estilo 😎",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Column {
            Greeting("Android")
            CustomButton {}
            MyCardExample()
            MySnackbarExample()
        }
    }
}
