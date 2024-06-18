package com.example.loginchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginchallenge.R
import com.example.loginchallenge.ui.component.PromotionItem
import com.example.loginchallenge.ui.component.TransactionItem
import com.example.loginchallenge.ui.home.state.Movement
import com.example.loginchallenge.ui.home.state.Promotion
import com.example.loginchallenge.ui.theme.Blue40
import com.example.loginchallenge.ui.theme.LoginChallengeTheme
import com.example.loginchallenge.ui.theme.LoginTheme
import com.example.loginchallenge.ui.theme.Typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onBack: () -> Unit = {}) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        ProfileSection(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = LoginTheme.dimens.Space32)
        ) { onBack() }
        BalanceSection(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(LoginTheme.dimens.Space16)
        )
        PromotionsSection()
        LastTransactions(modifier = Modifier.padding(top = LoginTheme.dimens.Space32))
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier, onBack: () -> Unit = {}) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = { onBack() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.back_button_description)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = stringResource(id = R.string.profile_image_description),
            modifier = Modifier.size(48.dp)
        )
        Text(
            text = "Larissa",
            style = Typography.labelLarge,
            modifier = Modifier.padding(start = LoginTheme.dimens.Space8)
        )
    }
}

@Composable
fun BalanceSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = R.string.balance_label))
        Text(
            text = "$24,960.00",
            style = Typography.titleLarge,
            modifier = Modifier.padding(top = LoginTheme.dimens.Space16)
        )
    }
}

@Composable
fun PromotionsSection(modifier: Modifier = Modifier) {
    val promotions = remember {
        listOf(
            Promotion(
                icon = R.drawable.ic_amazon,
                title = "Amazon Prime",
                description = "Get 20% Discount off your entire purschase"
            ),
            Promotion(
                icon = R.drawable.ic_spotify,
                title = "Spotify Premium",
                description = "Get 40% Discount off your entire purschase"
            ),
        )
    }

    Column(modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = LoginTheme.dimens.Space32,
                    bottom = LoginTheme.dimens.Space16,
                    start = LoginTheme.dimens.Space16,
                    end = LoginTheme.dimens.Space16
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.promotion_section_title),
                style = Typography.labelLarge
            )
            Text(
                text = stringResource(id = R.string.section_action_label),
                style = Typography.labelSmall.copy(color = Blue40),
                textDecoration = TextDecoration.Underline
            )
        }
        LazyRow {
            items(promotions) {
                PromotionItem(
                    modifier = Modifier.padding(horizontal = LoginTheme.dimens.Space8),
                    icon = it.icon,
                    title = it.title,
                    description = it.description
                )
            }

        }
    }
}

@Composable
fun LastTransactions(modifier: Modifier = Modifier) {
    val listOfMovements = remember {
        listOf(
            Movement(
                icon = R.drawable.ic_spotify,
                title = "Spotify Premium",
                category = "Social",
                amount = 105.0,
                date = "13/05/24"
            ),
            Movement(
                icon = R.drawable.ic_amazon,
                title = "Amazon Prime",
                category = "Social",
                amount = 99.0,
                date = "10/06/24"
            ),
        )
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = LoginTheme.dimens.Space16)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = LoginTheme.dimens.Space32,
                    bottom = LoginTheme.dimens.Space16,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.last_transactions_section_title),
                style = Typography.labelLarge
            )
            Text(
                text = stringResource(id = R.string.section_action_label),
                style = Typography.labelSmall.copy(color = Blue40),
                textDecoration = TextDecoration.Underline
            )
        }
        LazyColumn {
            items(listOfMovements) {
                TransactionItem(
                    modifier = Modifier.padding(vertical = LoginTheme.dimens.Space4),
                    icon = it.icon,
                    title = it.title,
                    category = it.category,
                    amount = it.amount,
                    date = it.date
                )
            }
        }
    }
}



@Preview(showBackground = true, device = Devices.NEXUS_6)
@Composable
private fun HomeScreenPreview() {
    LoginChallengeTheme {
        Surface { HomeScreen() }
    }
}