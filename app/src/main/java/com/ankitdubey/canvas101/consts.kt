package com.ankitdubey.canvas101

/**
 * Created by Ankit Dubey on 04,September,2021
 */


enum class CardType(val value : String){
    CHARTS("Charts"),
    CLOCK("Clock"),
    GIT_CAT("Github Cat")
}

val cards = listOf(
    CardType.GIT_CAT,
    CardType.CLOCK,
    CardType.CHARTS
)

val cardsImage = hashMapOf(
    CardType.CHARTS to R.drawable.charts,
    CardType.GIT_CAT to R.drawable.github_cat
)