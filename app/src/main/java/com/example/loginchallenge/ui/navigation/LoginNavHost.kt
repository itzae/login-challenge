package com.example.loginchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginchallenge.ui.home.HomeScreen
import com.example.loginchallenge.ui.login.LoginScreen
import com.example.loginchallenge.ui.login.LoginViewModel

@Composable
fun LoginNavHost(
    navHostController: NavHostController = rememberNavController(), viewModel: LoginViewModel
) {
    NavHost(navController = navHostController, startDestination = LoginScreens.LoginScreen.route) {

        composable(route = LoginScreens.LoginScreen.route) {
            val loginState by viewModel.loginState.collectAsState()
            LoginScreen(loginState = loginState, onLogin = { email, password ->
                viewModel.loginAttempt(email, password)
            }, onNavigate = {
                navHostController.navigate(LoginScreens.HomeScreen.route) {
                    launchSingleTop = true
                }
            })
        }
        composable(route = LoginScreens.HomeScreen.route) {
            HomeScreen { navHostController.navigateUp() }
        }
    }
}

sealed class LoginScreens(val route: String) {
    data object LoginScreen : LoginScreens("login")
    data object HomeScreen : LoginScreens("home")
}