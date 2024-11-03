// CommonComponents.kt
package com.example.walletwise.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.walletwise.R

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