package com.example.loginchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginchallenge.R
import com.example.loginchallenge.ui.theme.LoginChallengeTheme
import com.example.loginchallenge.ui.theme.LoginTheme
import com.example.loginchallenge.ui.theme.Typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hola, Itzae",
            style = Typography.titleMedium,
            modifier = Modifier
                .weight(0.2f)
                .align(Alignment.Start)
                .padding(LoginTheme.dimens.Space16),
        )
        Card(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth()
                .padding(LoginTheme.dimens.Space16)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Saldo",
                    style = Typography.titleMedium,
                    modifier = Modifier.padding(start = LoginTheme.dimens.Space18)
                )
                Text(
                    text = "$ 4,000",
                    style = Typography.titleMedium,
                    modifier = Modifier.padding(end = LoginTheme.dimens.Space18)
                )
            }
        }
        EmptyState(
            modifier = Modifier
                .weight(0.8f)
                .padding(LoginTheme.dimens.Space16)
        )

    }
}

@Composable
fun EmptyState(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty_wallet),
            contentDescription = "image",
        )
        Text(text = stringResource(id = R.string.empty_state_title), style = Typography.titleLarge)
        Text(text = stringResource(id = R.string.empty_state_description), style = Typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LoginChallengeTheme {
        HomeScreen()
    }
}