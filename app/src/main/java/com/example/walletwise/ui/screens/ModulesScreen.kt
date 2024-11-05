package com.example.walletwise.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.walletwise.ui.Header
import com.example.walletwise.ui.theme.WalletWiseTheme

@Composable
fun ModulesScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { Header(navController) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                SectionHeader("Aprende a abrir una cuenta bancaria")
                RowGrid(items = listOf("1" to Color(0xFF3F51B5), "2" to Color(0xFF3F51B5), "3" to Color.White, "4" to Color.White))
                Spacer(modifier = Modifier.height(32.dp))

                SectionHeader("Cómo transferir dinero a otra cuenta")
                RowGrid(items = listOf("1" to Color(0xFF3F51B5), "2" to Color.White))
                Spacer(modifier = Modifier.height(32.dp))

                SectionHeader("¿Qué es el Crédito y cómo Funciona?")
                RowGrid(items = listOf("1" to Color(0xFF3F51B5), "2" to Color(0xFF3F51B5), "3" to Color(0xFF3F51B5), "4" to Color(0xFF3F51B5), "5" to Color.White))
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun RowGrid(items: List<Pair<String, Color>>) {
    items.chunked(2).forEach { rowItems ->
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            rowItems.forEachIndexed { index, (number, color) ->
                CircleGridItem(number, color)
                // Agrega espacio solo entre los dos primeros elementos de cada fila
                if (index < rowItems.size - 1) {
                    Spacer(modifier = Modifier.width(56.dp)) // Ajusta el tamaño según el espacio deseado
                }
            }
            if (rowItems.size == 1) {
                Spacer(modifier = Modifier.size(80.dp)) // Espacio adicional para centrar
            }
        }
    }
}

@Composable
fun CircleGridItem(number: String, backgroundColor: Color) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(80.dp)  // Tamaño fijo cuadrado para cada botón
    ) {
        CircleButton(number, backgroundColor)
    }
}

@Composable
fun CircleButton(number: String, backgroundColor: Color) {
    Surface(
        shape = CircleShape,
        color = backgroundColor,
        modifier = Modifier.size(80.dp)  // Asegurando un tamaño fijo circular
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = number,
                textAlign = TextAlign.Center,
                color = if (backgroundColor == Color.White) Color.Black else Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModulesScreenPreview() {
    WalletWiseTheme {
        val fakeNavController = rememberNavController()
        ModulesScreen(navController = fakeNavController)
    }
}