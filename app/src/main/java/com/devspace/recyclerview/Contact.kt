package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val phone: String,
    @DrawableRes val icon: Int
)

val contacts = listOf(
    Contact("Ale", "(+55) 11 91234-5678", R.drawable.ale),
    Contact("Bach", "(+55) 11 91234-5678", R.drawable.bach),
    Contact("Caian Corporativo", "(+55) 11 91234-5678", R.drawable.caian1),
    Contact("Caian Pessoal", "(+55) 11 91234-5678", R.drawable.caian2),
    Contact("Ximbinha", "(+55) 11 91234-5678", R.drawable.chimbinha),
    Contact("Sr Defumado", "(+55) 11 91234-5678", R.drawable.furtado),
    Contact("Goku", "(+55) 11 91234-5678", R.drawable.goku),
    Contact("Lalau Machiavelli", "(+55) 11 91234-5678", R.drawable.lalau),
    Contact("Miguel Jefferson", "(+55) 11 91234-5678", R.drawable.miguel),
    Contact("Muniz", "(+55) 11 91234-5678", R.drawable.muniz),
    Contact("Mussum", "(+55) 11 91234-5678", R.drawable.mussum),
    Contact("Pericles", "(+55) 11 91234-5678", R.drawable.pericles),
    Contact("Urecubaba", "(+55) 11 91234-5678", R.drawable.rockbama),
    Contact("Silvao", "(+55) 11 91234-5678", R.drawable.silvao),
    Contact("Gatinho", "(+55) 11 91234-5678", R.drawable.gato)
)