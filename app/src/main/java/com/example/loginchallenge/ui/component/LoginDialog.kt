package com.example.loginchallenge.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginchallenge.ui.theme.LoginChallengeTheme

@Composable
fun LoginDialog(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    confirmButtonLabel: String,
    onConfirm: () -> Unit = {}
) {
    AlertDialog(
        modifier = modifier,
        title = { Text(text = title) },
        text = { Text(text = description) },
        onDismissRequest = { /*TODO*/ },
        confirmButton = { TextButton(onClick = {}, content = { Text(text = "Continuar") }) })
}

@Preview(showBackground = true)
@Composable
private fun LoginDialogPreview() {
    LoginChallengeTheme {
        LoginDialog(
            title = "Bienvenido, Itzae",
            description = "Inicio de sesión exitoso.",
            confirmButtonLabel = "Continuar"
        )
    }
}