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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.walletwise.R
import com.example.walletwise.ui.Header

@Composable
fun ChallengesScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { Header(navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Retos",
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onBackground, // Ajuste según el tema
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            Text(
                text = "You have saved 3 images",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f) // Ajuste según el tema
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Row for the first two images
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ChallengeImageCard(title = "Image 1 Heading", subtitle = "Sub-heading")
                ChallengeImageCard(title = "Image 2 Heading", subtitle = "Sub-heading")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Publicidad section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFFE91E63), shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Publicidad", textAlign = TextAlign.Center, color = Color.White,)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Third image card
            ChallengeImageCard(title = "Image 3 Heading", subtitle = "Sub-heading")
        }
    }
}

@Composable
fun ChallengeImageCard(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp)) // Color ajustado según el tema
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.challenge), // Puedes cambiar esto por la imagen que desees
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f), shape = RoundedCornerShape(8.dp)) // Fondo de imagen ajustado según el tema
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface, // Ajuste según el tema
            textAlign = TextAlign.Center
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f), // Ajuste según el tema
            textAlign = TextAlign.Center
        )
    }
}