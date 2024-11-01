package com.example.walletwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import com.example.walletwise.ui.theme.WalletWiseTheme
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletWiseTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            ContentSection()
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Acción para notificaciones */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notificación"
            )
        }
        IconButton(onClick = { /* Acción para perfil */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Perfil"
            )
        }
    }
}

@Composable
fun ContentSection() {
    Column {
        // Imagen superior (desde drawable)
        Image(
            painter = painterResource(id = R.drawable.ic_banner),
            contentDescription = "Banner principal",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp) // Ajusta la altura según tus necesidades
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
                .height(100.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("Publicidad", textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(16.dp))

        val imageUrl = "https://placehold.jp/150x150.png"
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
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

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_home), contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { /* Acción al hacer clic en Home */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_modules), contentDescription = "Módulos") },
            label = { Text("Módulos") },
            selected = false,
            onClick = { /* Acción al hacer clic en Módulos */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_challenges), contentDescription = "Retos") },
            label = { Text("Retos") },
            selected = false,
            onClick = { /* Acción al hacer clic en Retos */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    WalletWiseTheme {
        MainScreen()
    }
}