package com.example.loginchallenge.ui.login

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.loginchallenge.domain.usecase.LoginUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginScreenInstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp(){
        viewModel = LoginViewModel(LoginUseCase())
    }

    @Test
    fun testLoginSuccessful() {
        composeTestRule.setContent {
            val loginState by viewModel.loginState.collectAsState()
            LoginScreen(
                loginState = loginState,
                onLogin = { email, password -> viewModel.loginAttempt(email, password) })
        }
        composeTestRule.onNodeWithText("Email").performTextInput("itzaeg@gmail.com")
        composeTestRule.onNodeWithText("Contraseña").performTextInput("PasswordTest123")
        composeTestRule.onNodeWithText("Ingresar").performClick()

        composeTestRule.onNodeWithText("Bienvenido, Itzae").assertIsDisplayed()
    }

    @Test
    fun testLoginWithBadCredentialsError() {
        composeTestRule.setContent {
            val loginState by viewModel.loginState.collectAsState()
            LoginScreen(
                loginState = loginState,
                onLogin = { email, password -> viewModel.loginAttempt(email, password) })
        }
        composeTestRule.onNodeWithText("Email").performTextInput("itzaeg@gmail.com")
        composeTestRule.onNodeWithText("Contraseña").performTextInput("Password")
        composeTestRule.onNodeWithText("Ingresar").performClick()

        composeTestRule.onNodeWithText("Upss..").assertIsDisplayed()
    }

    @Test
    fun testLoginWithInvalidEmailFormat() {
        composeTestRule.setContent {
            val loginState by viewModel.loginState.collectAsState()
            LoginScreen(
                loginState = loginState,
                onLogin = { email, password -> viewModel.loginAttempt(email, password) })
        }
        composeTestRule.onNodeWithText("Email").performTextInput("@gmail.com")
        composeTestRule.onNodeWithText("Contraseña").performTextInput("PasswordTest123")
        composeTestRule.onNodeWithText("Ingresar").performClick()

        composeTestRule.onNodeWithText("El correo no es valido").assertIsDisplayed()
    }

    @Test
    fun testLoginButton() {
        composeTestRule.setContent {
            LoginScreen()
        }
        composeTestRule.onNodeWithText("Email").performTextInput("")
        composeTestRule.onNodeWithText("Contraseña").performTextInput("")

        composeTestRule.onNodeWithText("Ingresar").assertIsNotEnabled()

    }

    @Test
    fun testLoginTogglePassword() {
        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule.onNodeWithTag("password_text_field").performTextInput("PasswordTest")
        composeTestRule.onNodeWithContentDescription("Mostrar contraseña").performClick()
        composeTestRule.onNodeWithTag("password_text_field").assertTextEquals("PasswordTest")
        composeTestRule.onNodeWithContentDescription("Ocultar contraseña").assertExists()
        composeTestRule.onNodeWithContentDescription("Ocultar contraseña").performClick()
        composeTestRule.onNodeWithContentDescription("Mostrar contraseña").assertExists()
    }


}