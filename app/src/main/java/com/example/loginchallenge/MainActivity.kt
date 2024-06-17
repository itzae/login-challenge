package com.example.loginchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.loginchallenge.ui.login.LoginViewModel
import com.example.loginchallenge.ui.navigation.LoginNavHost
import com.example.loginchallenge.ui.theme.LoginChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginChallengeTheme(dynamicColor = false) {
                LoginNavHost(viewModel = viewModel)
            }
        }
    }
}