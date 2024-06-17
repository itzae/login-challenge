package com.example.loginchallenge.ui.login

import androidx.lifecycle.ViewModel
import com.example.loginchallenge.domain.usecase.LoginUseCase
import com.example.loginchallenge.ui.login.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState>
        get() = _loginState.asStateFlow()

    fun loginAttempt(email: String, password: String) {

        try {
            if (loginUseCase(email, password))
                _loginState.update {
                    LoginState.SuccessfulLogin(
                        title = "Bienvenido, Itzae",
                        message = "Inicio de sesión exitoso."
                    )
                }
            else
                _loginState.update {
                    LoginState.BadCredentialsLogin(
                        title = "Upss..",
                        message = "El email o contraseña son incorrectos"
                    )
                }
        } catch (e: Exception) {
            _loginState.update { LoginState.IncorrectEmail }
        }
    }
}