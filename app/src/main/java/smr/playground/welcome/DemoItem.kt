package smr.playground.welcome

import androidx.annotation.DrawableRes
import smr.playground.R

data class DemoItem(
    val title: String = "Title",
    val summary: String = "This is the summary text",
    @DrawableRes val imageResIdRes: Int = R.drawable.ic_food
)