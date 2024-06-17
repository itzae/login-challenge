package com.example.loginchallenge.domain

import com.example.loginchallenge.domain.usecase.LoginUseCase
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class LoginUseCaseTest {
    private lateinit var loginUseCase: LoginUseCase

    @Before
    fun setUp() {
        loginUseCase = LoginUseCase()
    }

    @Test
    fun `Login with correct credentials return true`() {
        val email = "test@gmail.com"
        val password = "PasswordTest123"

        assertThat(loginUseCase(email, password)).isTrue()
    }

    @Test
    fun `Login with incorrect credential return false`() {
        val email = "paul@example.com"
        val password = "PasswordTest1234"

        assertThat(loginUseCase(email, password)).isFalse()
    }

    @Test
    fun `Login with incorrect email format`() {
        val email = "@example.com"
        val password = "PasswordTest1234"

        try {
            loginUseCase(email, password)
        } catch (e: Exception) {
            assertThat(e).hasMessageThat().isEqualTo("You've entered incorrect email format")
        }
    }
}