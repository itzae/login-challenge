package com.example.loginchallenge.ui.login.state

sealed interface LoginState {
    data object Idle : LoginState
    data object IncorrectEmail : LoginState
    data class SuccessfulLogin(val title: String, val message: String) : LoginState
    data class BadCredentialsLogin(val title: String, val message: String) : LoginState
}

