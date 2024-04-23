package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class Contact(
    val Name: String,
    val phone: String,
    @DrawableRes val icon: Int
)
