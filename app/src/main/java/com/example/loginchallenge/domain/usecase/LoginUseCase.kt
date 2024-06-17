package com.example.loginchallenge.domain.usecase

import javax.inject.Inject

class LoginUseCase @Inject constructor() {
    operator fun invoke(email: String, password: String): Boolean {
        val regex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return if (regex.toRegex().matches(email)) {
            email == "itzaeg@gmail.com" && password == "PasswordTest123"
        } else throw IllegalArgumentException("You've entered incorrect email format")
    }
}