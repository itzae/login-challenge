package com.example.loginchallenge.ui.login

import app.cash.turbine.test
import com.example.loginchallenge.domain.usecase.LoginUseCase
import com.example.loginchallenge.ui.login.state.LoginState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class LoginViewModelTest {
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        loginViewModel = LoginViewModel(LoginUseCase())
    }

    @Test
    fun `Login attempt with valid credentials`() = runTest {
        loginViewModel.loginAttempt("itzaeg@gmail.com", "PasswordTest123")
        loginViewModel.loginState.test {
            assertThat(awaitItem()).isEqualTo(
                LoginState.SuccessfulLogin(
                    title = "Bienvenido, Itzae",
                    message = "Inicio de sesión exitoso."
                )
            )
        }
    }

    @Test
    fun `Login attempt with invalid credentials`() = runTest {
        loginViewModel.loginAttempt("itzaeg@gmail.com", "PasswordTest")
        loginViewModel.loginState.test {
            assertThat(awaitItem()).isEqualTo(
                LoginState.BadCredentialsLogin(
                    title = "Upss..", message = "El email o contraseña son incorrectos"
                )
            )
        }
    }

    @Test
    fun `Login attempt with invalid email format`() = runTest {
        loginViewModel.loginAttempt("itzaeg@.com", "PasswordTest")
        loginViewModel.loginState.test {
            assertThat(awaitItem()).isEqualTo(LoginState.IncorrectEmail)
        }
    }
}