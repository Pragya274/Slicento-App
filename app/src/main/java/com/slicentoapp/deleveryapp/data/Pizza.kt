package com.slicentoapp.deleveryapp.data

import androidx.annotation.DrawableRes
import com.slicentoapp.deleveryapp.R

data class Pizza(
    val id: Int,
    val name: String,
    val description: String,
    val price: Number,
    @DrawableRes val image: Int
)


val pizzas = listOf(
    Pizza(1, "Pepperoni", "A classic pizza topped with slices of spicy pepperoni, melted mozzarella cheese, and rich tomato sauce, perfect for meat lovers seeking a flavorful experience.", 9.99f, R.drawable.pizza1),
    Pizza(2, "Margherita", "A traditional Italian pizza featuring a simple yet delicious combination of tangy tomato sauce, fresh mozzarella cheese, and fragrant basil leaves.", 8.99f, R.drawable.pizza2),
    Pizza(3, "Hawaiian", "A unique blend of sweet and savory with ham, juicy pineapple chunks, and melted cheese, offering a tropical twist to your pizza experience.", 10.99f, R.drawable.pizza3),
    Pizza(4, "Vegetarian", "A colorful and healthy choice with bell peppers, onions, mushrooms, and cheese, perfect for those who love their veggies.", 11.99f, R.drawable.pizza4),
    Pizza(5, "Sausage", "A hearty pizza loaded with savory sausage slices, pepperoni, and gooey cheese, ideal for a filling and satisfying meal.", 9.99f, R.drawable.pizza1),
    Pizza(6, "BBQ Chicken", "A tantalizing mix of BBQ chicken, crispy bacon, and cheese, offering a smoky and savory delight for BBQ enthusiasts.", 12.99f, R.drawable.pizza2),
    Pizza(7, "Mushroom", "A delightful pizza with a generous topping of mushrooms, melted mozzarella, and rich tomato sauce, perfect for mushroom lovers.", 10.99f, R.drawable.pizza3),
    Pizza(8, "Meat lovers", "A meaty feast with pepperoni, sausage, bacon, and ham, ensuring every bite is packed with robust flavors.", 14.99f, R.drawable.pizza4),
    Pizza(9, "Veggie", "A garden-fresh pizza with onions, bell peppers, mushrooms, and olives, offering a burst of flavors and textures.", 12.99f, R.drawable.pizza1),
    Pizza(10, "Shrimp Scampi", "A gourmet pizza topped with succulent shrimp, garlic, and parsley, providing a seafood lover's paradise.", 16.99f, R.drawable.pizza2),
    Pizza(11, "Four cheese", "An indulgent pizza featuring a blend of mozzarella, parmesan, provolone, and gorgonzola, creating a cheesy masterpiece.", 13.99f, R.drawable.pizza3),
    Pizza(12, "Greek", "A Mediterranean-inspired pizza with feta cheese, olives, artichokes, and sun-dried tomatoes, delivering a taste of Greece.", 13.99f, R.drawable.pizza4),
    Pizza(13, "Meatball", "A savory pizza loaded with juicy meatballs, marinara sauce, and melted mozzarella, offering a hearty and satisfying experience.", 15.99f, R.drawable.pizza1),
    Pizza(14, "Bacon cheeseburger", "A unique twist on a classic burger, this pizza features ground beef, crispy bacon, and cheddar cheese, perfect for burger fans.", 14.99f, R.drawable.pizza2),
    Pizza(15, "Pesto", "A flavorful pizza with pesto sauce, tender chicken, and creamy mozzarella, providing a fresh and aromatic experience.", 14.99f, R.drawable.pizza3),
    Pizza(16, "Artichoke", "A delightful combination of artichokes, sun-dried tomatoes, and feta cheese, offering a sophisticated and savory flavor profile.", 13.99f, R.drawable.pizza4),
    Pizza(17, "Sicilian", "A hearty pizza topped with tomato sauce, mozzarella, and spicy pepperoni, delivering a bold and satisfying taste.", 14.99f, R.drawable.pizza1),
    Pizza(18, "Capricciosa", "A classic Italian pizza with ham, mushrooms, artichokes, and olives, providing a rich and flavorful experience.", 15.99f, R.drawable.pizza2),
    Pizza(19, "Four meat", "A robust pizza with a generous topping of pepperoni, sausage, bacon, and ham, ensuring a meaty delight in every bite.", 16.99f, R.drawable.pizza3),
    Pizza(20, "Quattro formaggi", "A cheesy delight featuring four different types of cheese, creating a rich and indulgent pizza experience.", 16.99f, R.drawable.pizza4),
    Pizza(21, "Sicilian", "A hearty pizza topped with tomato sauce, mozzarella, and spicy pepperoni, delivering a bold and satisfying taste.", 14.99f, R.drawable.pizza1),
    Pizza(22, "Capricciosa", "A classic Italian pizza with ham, mushrooms, artichokes, and olives, providing a rich and flavorful experience.", 15.99f, R.drawable.pizza2),
    Pizza(23, "Four meat", "A robust pizza with a generous topping of pepperoni, sausage, bacon, and ham, ensuring a meaty delight in every bite.", 16.99f, R.drawable.pizza3),
    Pizza(24, "Quattro formaggi", "A cheesy delight featuring four different types of cheese, creating a rich and indulgent pizza experience.", 16.99f, R.drawable.pizza4),
    Pizza(25, "Sicilian", "A hearty pizza topped with tomato sauce, mozzarella, and spicy pepperoni, delivering a bold and satisfying taste.", 14.99f, R.drawable.pizza1),
    Pizza(26, "Capricciosa", "A classic Italian pizza with ham, mushrooms, artichokes, and olives, providing a rich and flavorful experience.", 15.99f, R.drawable.pizza2),
    Pizza(27, "Four meat", "A robust pizza with a generous topping of pepperoni, sausage, bacon, and ham, ensuring a meaty delight in every bite.", 16.99f, R.drawable.pizza3),
    Pizza(28, "Quattro formaggi", "A cheesy delight featuring four different types of cheese, creating a rich and indulgent pizza experience.", 16.99f, R.drawable.pizza4),
    Pizza(29, "Sicilian", "A hearty pizza topped with tomato sauce, mozzarella, and spicy pepperoni, delivering a bold and satisfying taste.", 14.99f, R.drawable.pizza1),
    Pizza(30, "Capricciosa", "A classic Italian pizza with ham, mushrooms, artichokes, and olives, providing a rich and flavorful experience.", 15.99f, R.drawable.pizza2),
    Pizza(31, "Four meat", "A robust pizza with a generous topping of pepperoni, sausage, bacon, and ham, ensuring a meaty delight in every bite.", 16.99f, R.drawable.pizza3),
    Pizza(32, "Quattro formaggi", "A cheesy delight featuring four different types of cheese, creating a rich and indulgent pizza experience.", 16.99f, R.drawable.pizza4)


)