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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.tooling.preview.Preview
import com.example.walletwise.ui.Header
import com.example.walletwise.ui.theme.WalletWiseTheme

@Composable
fun ModulesScreen() {
    Scaffold(
        topBar = { Header() }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Aprende a abrir una cuenta bancaria",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item { CircleGridItem("1", Color(0xFF3F51B5)) }
                item { CircleGridItem("2", Color(0xFF3F51B5)) }
                item { CircleGridItem("3", Color.White) }
                item { CircleGridItem("4", Color.White) }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Cómo transferir dinero a otra cuenta",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item { CircleGridItem("1", Color(0xFF3F51B5)) }
                item { CircleGridItem("2", Color.White) }
            }
        }
    }
}

@Composable
fun CircleGridItem(number: String, backgroundColor: Color) {
    // Este Box asegura el tamaño exacto y forma circular de cada botón
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
        ModulesScreen()
    }
}