package com.example.loginchallenge.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Dimens(
    val Space4: Dp = 4.dp,
    val Space8: Dp = 8.dp,
    val Space18: Dp = 18.dp,
    val Space32: Dp = 32.dp,
    val Space34: Dp = 34.dp,
)

internal val LocalDimens = staticCompositionLocalOf { Dimens() }

object LoginTheme {
    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = LocalDimens.current
}