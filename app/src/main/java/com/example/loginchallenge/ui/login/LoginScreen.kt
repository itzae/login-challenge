package com.example.loginchallenge.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginchallenge.R
import com.example.loginchallenge.ui.component.LoginDialog
import com.example.loginchallenge.ui.component.LoginTextField
import com.example.loginchallenge.ui.login.state.LoginState
import com.example.loginchallenge.ui.theme.LoginChallengeTheme
import com.example.loginchallenge.ui.theme.LoginTheme
import com.example.loginchallenge.ui.theme.Typography

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginState: LoginState = LoginState.Idle,
    onLogin: (email: String, password: String) -> Unit = { _, _ -> }
) {
    var isOpenDialog by remember {
        mutableStateOf(true)
    }
    when (loginState) {
        is LoginState.SuccessfulLogin ->
            LoginDialog(
                title = loginState.title,
                description = loginState.message,
                confirmButtonLabel = stringResource(id = R.string.login_successful_dialog_button)
            )

        is LoginState.BadCredentialsLogin -> {
            if (isOpenDialog)
                LoginDialog(
                    title = loginState.title,
                    description = loginState.message,
                    confirmButtonLabel = stringResource(id = R.string.login_error_dialog_button),
                    onConfirm = { isOpenDialog = false }
                )
        }

        else -> Unit
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {

        LoginHeader(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        LoginBody(
            modifier = Modifier.weight(1f),
            isEmailError = loginState is LoginState.IncorrectEmail,
            onLogin = { email, password ->
                onLogin(email, password)
                isOpenDialog = true
            })
    }
}

@Composable
fun LoginHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_image),
            contentDescription = stringResource(id = R.string.header_image_description),
        )
    }
}

@Composable
fun LoginBody(
    modifier: Modifier = Modifier,
    isEmailError: Boolean,
    onLogin: (email: String, password: String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(modifier = modifier) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = LoginTheme.dimens.Space32),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.login_title),
                style = Typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = LoginTheme.dimens.Space18)
            )

            LoginTextField(
                text = email,
                placeholder = stringResource(id = R.string.email_input_placeholder),
                onTextChange = { email = it },
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                isError = isEmailError,
                helperText = if (isEmailError) stringResource(id = R.string.invalid_email_helper_text) else "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = LoginTheme.dimens.Space8)
                    .testTag("email_text_field")
            )
            LoginTextField(
                text = password,
                placeholder = stringResource(id = R.string.password_input_placeholder),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                onTextChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = LoginTheme.dimens.Space8)
                    .testTag("password_text_field")
            )
            Button(
                onClick = { onLogin(email, password) },
                shape = RoundedCornerShape(20),
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                modifier = Modifier
                    .imePadding()
                    .fillMaxWidth()
                    .padding(top = LoginTheme.dimens.Space34)

            ) {
                Text(
                    text = stringResource(id = R.string.login_button),
                    style = Typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .imePadding()
                        .padding(vertical = LoginTheme.dimens.Space4),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginChallengeTheme(dynamicColor = false) {
        LoginScreen()
    }
}