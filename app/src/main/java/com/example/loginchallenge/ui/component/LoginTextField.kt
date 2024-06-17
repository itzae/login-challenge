package com.example.loginchallenge.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.loginchallenge.R
import com.example.loginchallenge.ui.theme.Typography

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String = "",
    helperText: String? = null,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.None,
    onTextChange: (String) -> Unit
) {
    var isPasswordHide by remember {
        mutableStateOf(true)
    }
    val inputTransformation =
        if (keyboardType == KeyboardType.Password && isPasswordHide) PasswordVisualTransformation() else VisualTransformation.None

    val iconTogglePassword =
        if (keyboardType == KeyboardType.Password && isPasswordHide) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

    val togglePasswordDescription =
        if (isPasswordHide)
            stringResource(id = R.string.toggle_show_password_description)
        else
            stringResource(id = R.string.toggle_hide_password_description)

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(text = placeholder, style = Typography.labelMedium) },
        isError = isError,
        supportingText = helperText?.let { { Text(text = helperText) } },
        trailingIcon = if (keyboardType == KeyboardType.Password) {
            {
                IconButton(onClick = { isPasswordHide = !isPasswordHide }) {
                    Icon(
                        imageVector = iconTogglePassword,
                        contentDescription = togglePasswordDescription
                    )
                }
            }
        } else null,
        shape = RoundedCornerShape(20),
        visualTransformation = inputTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        singleLine = true
    )
}