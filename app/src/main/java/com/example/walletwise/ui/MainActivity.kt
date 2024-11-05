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
import com.example.walletwise.ui.screens.LoginScreen
import com.example.walletwise.ui.screens.ProfileDetailScreen
import com.example.walletwise.ui.screens.ProfileScreen
import com.example.walletwise.ui.screens.RegisterScreen
import com.example.walletwise.ui.screens.LeaderboardScreen
import com.example.walletwise.ui.theme.WalletWiseTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletWiseTheme {
                val navController = rememberNavController()
                MainNavigation(navController)
            }
        }
    }
}

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login" // La pantalla de inicio de sesión será la primera en cargarse
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register") {
            RegisterScreen(navController = navController)
        }
        composable("home") {
            MainScreenWithBottomNav(navController) { modifier ->
                HomeScreen(navController = navController, modifier = modifier)
            }
        }
        composable("modules") {
            MainScreenWithBottomNav(navController) { modifier ->
                ModulesScreen(navController = navController, modifier = modifier)
            }
        }
        composable("challenges") {
            MainScreenWithBottomNav(navController) { modifier ->
                ChallengesScreen(navController = navController, modifier = modifier)
            }
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("profileDetail") { ProfileDetailScreen(navController = navController) }
        composable("leaderboard") { LeaderboardScreen(navController = navController) }
    }
}

@Composable
fun MainScreenWithBottomNav(
    navController: NavHostController,
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }  // Barra de navegación inferior
    ) { padding ->
        // Aplicamos el padding proporcionado al content
        content(Modifier.padding(padding))
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
fun MainActivityPreview() {
    WalletWiseTheme {
        val navController = rememberNavController()
        MainNavigation(navController = navController)
    }
}