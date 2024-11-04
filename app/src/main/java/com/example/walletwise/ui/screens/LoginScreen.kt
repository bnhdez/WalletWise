package com.example.walletwise.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.walletwise.R
import com.example.walletwise.ui.theme.WalletWiseTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo de la aplicación
            Image(
                painter = painterResource(id = R.drawable.ic_lo), // Asegúrate de que ic_logo esté en drawable
                contentDescription = "Logo",
                modifier = Modifier
                    .size(160.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Título de la pantalla
            Text(
                text = "Iniciar Sesión",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de entrada para el email
            val email = remember { mutableStateOf("") }
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo de entrada para la contraseña
            val password = remember { mutableStateOf("") }
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de iniciar sesión
            Button(
                onClick = {
                    // Navega a la pantalla principal ("main") en lugar de "home"
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text("Iniciar Sesión")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Texto de inicio de sesión con redes sociales
            Text(
                text = "Inicia Sesión con Redes Sociales",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Botones de redes sociales
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* Lógica de inicio de sesión con Google */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Google", color = Color.Black)
                }

                Button(
                    onClick = { /* Lógica de inicio de sesión con Facebook */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4267B2)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Facebook", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Enlaces de Recuperar Contraseña y Registrarse
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = { /* Lógica para recuperar contraseña */ }) {
                    Text("Olvidaste la Contraseña?", color = Color.Gray)
                }
                TextButton(onClick = { navController.navigate("register") }) {
                    Text("Registrarse", color = Color(0xFF4267B2))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    WalletWiseTheme {
        val fakeNavController = rememberNavController()
        LoginScreen(navController = fakeNavController)
    }
}


