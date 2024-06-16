package com.example.loginchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.loginchallenge.ui.login.LoginScreen
import com.example.loginchallenge.ui.theme.LoginChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginChallengeTheme(dynamicColor = false) {
                LoginScreen()
            }
        }
    }
}