package com.example.loginchallenge.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginchallenge.R
import com.example.loginchallenge.ui.theme.LoginChallengeTheme
import com.example.loginchallenge.ui.theme.LoginTheme
import com.example.loginchallenge.ui.theme.Typography

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String = "",
    category: String = "",
    amount: Double = 0.0,
    date: String = ""
) {
    Card(modifier = modifier.fillMaxWidth().height(70.dp)) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "transaction item",
                modifier = Modifier
                    .padding(LoginTheme.dimens.Space16)
            )
            Column(Modifier.padding(end = LoginTheme.dimens.Space16)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = title, style = Typography.labelMedium)
                    Text(text = "$$amount", style = Typography.labelMedium)
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = LoginTheme.dimens.Space8),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = category, style = Typography.labelSmall)
                    Text(text = date, style = Typography.labelSmall)
                }
            }
        }
    }
}

@Preview
@Composable
private fun TransactionItemPreview() {
    LoginChallengeTheme {
        TransactionItem(
            icon = R.drawable.ic_spotify,
            title = "Spotify Premium",
            category = "Social",
            amount = 105.0,
            date = "25 Julio 2023"
        )
    }
}