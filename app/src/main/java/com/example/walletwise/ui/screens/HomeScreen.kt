package com.example.walletwise.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.walletwise.R
import com.example.walletwise.ui.Header
import com.example.walletwise.ui.theme.WalletWiseTheme
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { Header(navController)}  // Mantiene el Header en la parte superior de la pantalla
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)  // Asegura que el contenido no esté detrás del Header
                .padding(horizontal = 16.dp)
        ) {
            ContentSection()
        }
    }
}

@Composable
fun ContentSection() {
    Column {
        // Imagen superior (desde drawable)
        Image(
            painter = painterResource(id = R.drawable.banner1),
            contentDescription = "Banner principal",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Aprende a abrir una cuenta bancaria",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Para editar este texto, selecciona el cuadro de texto y haz doble clic...",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFFE91E63), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("Publicidad",color = Color.White, textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.banner2),
            contentDescription = "Imagen desde URL",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Cómo transferir dinero a otra cuenta",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Para editar este texto, selecciona el cuadro de texto y haz doble clic...",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    WalletWiseTheme {
        HomeScreen(navController = rememberNavController())
    }
}