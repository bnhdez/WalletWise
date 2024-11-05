package com.example.walletwise.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.walletwise.R
import com.example.walletwise.ui.Header
import com.example.walletwise.ui.theme.WalletWiseTheme
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { Header(navController) }  // Mantiene el Header en la parte superior de la pantalla
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)  // Asegura que el contenido no esté detrás del Header
                .padding(horizontal = 16.dp)
        ) {
            item { ContentSection() } // Usa LazyColumn para poder scrollear el contenido
            item { Spacer(modifier = Modifier.height(100.dp)) } // Espacio adicional al final
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
            text = "¿Listo para empezar a manejar tu dinero? Abrir una cuenta bancaria es el primer paso para organizar tus finanzas. Aprende sobre los tipos de cuentas, los requisitos y cómo elegir la opción que mejor se adapta a tus necesidades.",
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
            text = "¿Necesitas enviar dinero a un amigo o hacer un pago? Aquí aprenderás cómo transferir dinero de forma rápida y segura desde tu cuenta bancaria. Descubre los diferentes métodos de transferencia, sus costos y cómo evitar errores comunes.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.banner3),
            contentDescription = "Imagen desde URL",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "¿Qué es el Crédito y cómo Funciona?",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Un módulo que explique qué es el crédito, cómo funciona y por qué es importante manejarlo de manera responsable. Ideal para enseñar sobre tarjetas de crédito y puntajes de crédito.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.banner4),
            contentDescription = "Imagen desde URL",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Gestión de Gastos Diarios",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Un módulo práctico para aprender a monitorear y gestionar los gastos diarios, enseñando sobre presupuestos y categorías de gastos.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.banner5),
            contentDescription = "Imagen desde URL",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "La Importancia de un Fondo de Emergencia",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Módulo que enfatice la importancia de tener un fondo de emergencia y cómo calcular la cantidad ideal.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    WalletWiseTheme {
        HomeScreen(navController = rememberNavController())
    }
}