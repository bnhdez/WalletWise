package com.example.walletwise.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.walletwise.R

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = "Cerrar",
                        tint = MaterialTheme.colorScheme.onBackground // Cambia según el tema
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de perfil redonda
            Image(
                painter = painterResource(id = R.drawable.ic_user_avatar),
                contentDescription = "Avatar del Usuario",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del usuario y puntaje
            Text(
                text = "[Kevin]",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground // Cambia según el tema
            )
            Text(
                text = "⭐ 10,000",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant, // Cambia según el tema
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Opciones del perfil con navegación a detalles
            ProfileOption(
                icon = R.drawable.ic_profile,
                label = "Perfil",
                onClick = { navController.navigate("profileDetail") }
            )
            ProfileOption(
                icon = R.drawable.ic_leaderboard,
                label = "Leaderboard",
                onClick = { navController.navigate("leaderboard") }
            )
            ProfileOption(icon = R.drawable.ic_favorites, label = "Retos Favoritos")

            Spacer(modifier = Modifier.weight(1f))

            // Opción de premium, fijada en la parte inferior de la pantalla
            ProfileOption(
                icon = R.drawable.ic_premium,
                label = "Pásate a Premium",
                isPremium = true
            )
        }
    }
}

@Composable
fun ProfileOption(
    icon: Int,
    label: String,
    isPremium: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .then(
                if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = if (isPremium) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isPremium) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
        )
    }
}