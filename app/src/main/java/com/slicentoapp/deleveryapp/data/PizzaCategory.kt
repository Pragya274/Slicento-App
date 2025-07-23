package com.slicentoapp.deleveryapp.data

import androidx.annotation.DrawableRes
import com.slicentoapp.deleveryapp.R


data class PizzaCategory(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int

)

val pizzaCategories = listOf(
    PizzaCategory(1, "Pizza", R.drawable.pizza1),
    PizzaCategory(2, "Burger", R.drawable.pizza2),
    PizzaCategory(3, "Sushi", R.drawable.pizza3),
    PizzaCategory(4, "Donut", R.drawable.pizza4),
    PizzaCategory(5, "Ice Cream", R.drawable.pizza1),
    PizzaCategory(6, "Pizza", R.drawable.pizza2),
    PizzaCategory(7, "Burger", R.drawable.pizza3),
    PizzaCategory(8, "Sushi", R.drawable.pizza4),
)