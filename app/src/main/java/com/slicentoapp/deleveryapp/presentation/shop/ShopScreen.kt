package com.slicentoapp.deleveryapp.presentation.shop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.slicentoapp.deleveryapp.presentation.shop.components.PizzaCategoryList
import com.slicentoapp.deleveryapp.presentation.shop.components.PizzaList
import com.slicentoapp.deleveryapp.presentation.navigation.graph.AppGraph


@Composable
fun ShopScreen(appNavigation:NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Categories",
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        PizzaCategoryList()

        // Spacer
        Box(modifier = Modifier.height(8.dp))

        Text(
            text = "Pizzas",
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        PizzaList{
            appNavigation.navigate(AppGraph.ProductDetails(it.id))
        }


    }
}