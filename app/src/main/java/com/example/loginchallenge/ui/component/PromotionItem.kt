package com.example.loginchallenge.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginchallenge.R
import com.example.loginchallenge.ui.theme.LoginChallengeTheme
import com.example.loginchallenge.ui.theme.LoginTheme
import com.example.loginchallenge.ui.theme.Typography

@Composable
fun PromotionItem(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    title: String = "",
    description: String = ""
) {
    Card(modifier = modifier.size(200.dp, 150.dp)) {
        Column(modifier = modifier.padding(horizontal = LoginTheme.dimens.Space16)) {
            icon?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "Promotion logo",
                    modifier = Modifier.padding(vertical = LoginTheme.dimens.Space16)
                )
            }

            Text(
                text = title,
                style = Typography.labelMedium,
                modifier = Modifier.padding(bottom = LoginTheme.dimens.Space8)
            )
            Text(text = description, style = Typography.labelSmall)

        }
    }
}

@Preview
@Composable
private fun PromotionItemPreview() {
    LoginChallengeTheme {
        PromotionItem(
            icon = R.drawable.ic_amazon,
            title = "Amazon prime",
            description = "Get 20% Discount off your entire purschase"
        )
    }
}