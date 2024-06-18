package com.example.loginchallenge.ui.home.state

data class Promotion(val icon: Int, val title: String, val description: String)
data class Movement(
    val icon: Int,
    val title: String,
    val category: String,
    val amount: Double,
    val date: String
)