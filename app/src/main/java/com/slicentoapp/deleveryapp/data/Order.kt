package com.slicentoapp.deleveryapp.data

data class Order(
    val id: Int,
    val pizza: Pizza,
    val quantity: Int,
    val price: Double,
    val status: String,
    val ammount: Double = price * quantity
)


val orders = listOf(
    Order(1, pizzas[0], 2, 10.0, "Pending"),
    Order(2, pizzas[1], 1, 8.0, "Delivered"),
    Order(3, pizzas[2], 3, 12.0, "Delivered"),
    Order(4, pizzas[3], 1, 9.0, "Delivered"),
    Order(5, pizzas[4], 2, 11.0, "Delivered"),
    Order(6, pizzas[5], 1, 7.0, "Delivered"),
    Order(7, pizzas[6], 2, 10.0, "Delivered"),
    Order(8, pizzas[7], 1, 8.0, "Delivered"),
    Order(9, pizzas[8], 3, 12.0, "Delivered"),
    Order(10, pizzas[9], 1, 9.0, "Delivered")
)