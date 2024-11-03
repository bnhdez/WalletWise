package com.example.walletwise.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.walletwise.R
import com.example.walletwise.ui.screens.HomeScreen
import com.example.walletwise.ui.screens.ModulesScreen
import com.example.walletwise.ui.screens.ChallengesScreen
import com.example.walletwise.ui.theme.WalletWiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletWiseTheme {
                val navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("modules") { ModulesScreen() }
            composable("challenges") { ChallengesScreen() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_home), contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("home") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_modules), contentDescription = "Módulos") },
            label = { Text("Módulos") },
            selected = false,
            onClick = { navController.navigate("modules") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_challenges), contentDescription = "Retos") },
            label = { Text("Retos") },
            selected = false,
            onClick = { navController.navigate("challenges") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    WalletWiseTheme {
        val navController = rememberNavController()
        MainScreen(navController)
    }
}