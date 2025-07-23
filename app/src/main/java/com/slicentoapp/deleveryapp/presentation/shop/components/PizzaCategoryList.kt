package com.slicentoapp.deleveryapp.presentation.shop.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.slicentoapp.deleveryapp.data.PizzaCategory
import com.slicentoapp.deleveryapp.data.pizzaCategories


@Composable
fun PizzaCategoryList() {

    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        contentPadding = PaddingValues(start = 8.dp)
    ){

        items(pizzaCategories.size){index ->
            val category = pizzaCategories[index]
            PizzaCategoryItem(category = category)
        }

    }
}

@Composable
fun PizzaCategoryItem(category: PizzaCategory) {

    Column(
        modifier = Modifier.padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(id = category.image),
            contentDescription = category.name,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = category.name,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

    }

}