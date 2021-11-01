package com.ankitdubey.canvas101

/**
 * Created by Ankit Dubey on 04,September,2021
 */


enum class CardType(val value : String){
    CHARTS("Charts"),
    CLOCK("Clock"),
    GIT_CAT("Github Cat"),
    DONUT_SHAPE("Sweet Donut"),
    STATE_PICKER("State Picker")
}

val cards = listOf(
    CardType.GIT_CAT,
    CardType.CLOCK,
    CardType.CHARTS,
    CardType.DONUT_SHAPE,
    CardType.STATE_PICKER
)

val cardsImage = hashMapOf(
    CardType.CHARTS to R.drawable.charts,
    CardType.GIT_CAT to R.drawable.github_cat,
    CardType.DONUT_SHAPE to R.drawable.donut
)