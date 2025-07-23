package com.slicentoapp.deleveryapp.presentation.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsBike
import androidx.compose.material.icons.rounded.DirectionsBike
import androidx.compose.material.icons.rounded.EmojiTransportation
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.slicentoapp.deleveryapp.data.pizzas
import com.slicentoappapp.deleveryapp.presentation.details.components.DetailsAppBar
import com.slicentoapp.deleveryapp.presentation.navigation.graph.AppGraph
import com.slicentoapp.deleveryapp.presentation.shop.components.BottomSheet
import com.slicentoapp.deleveryapp.presentation.shop.components.PizzaList
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(id: Int, navigator: NavHostController) {

    val pizza = pizzas.find { it.id == id }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    val screenWidth = LocalConfiguration.current.screenWidthDp

    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(

    )
    var sheetState by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            DetailsAppBar(title = pizza?.name!!, scrollBehavior = scrollBehavior) {
                navigator.popBackStack()
            }
        },
        modifier = Modifier.fillMaxSize(),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(id = pizza?.image!!),
                contentDescription = pizza.name,
                modifier = Modifier
                    .size(screenWidth.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.FillBounds

            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = pizza.name,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                    modifier = Modifier,
                    color = Color.Black.copy(
                        0.6f
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))
                // prize
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "$${pizza.price}",
                        style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                        modifier = Modifier,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    // actual prize
                    Text(
                        text = "$${(pizza.price + 50).toInt()}",
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        modifier = Modifier,
                        color = Color.Black.copy(0.4f),
                        textDecoration = TextDecoration.LineThrough
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    // offer

                    Badge(
                        containerColor = Color(0xff009900),
                        contentColor = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = "-${100 - (pizza.price * 100 / (pizza.price + 50)).toInt()}%",
                            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                            modifier = Modifier,
                        )
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = "Description",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier,
                    color = Color.Black.copy(0.6f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = pizza.description,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    modifier = Modifier,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.padding(8.dp))



                RatingSection()

                DeliverySection()



                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier.weight(1f),
                        border = BorderStroke(
                            0.dp,
                            Color.Transparent
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                            containerColor = MaterialTheme.colorScheme.primary.copy(0.2f),
                        )
                    ) {
                        Text(text = "Add to cart", fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.padding(8.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                bottomSheetState.expand()
                                sheetState = true
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Buy now", fontWeight = FontWeight.Bold)
                    }
                }
            }


            HorizontalDivider(
                modifier = Modifier,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = "Related products",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = Color.Black
            )

            Spacer(modifier = Modifier.padding(8.dp))

            PizzaList {

                navigator.navigate(AppGraph.ProductDetails(it.id))

            }


        }



        if (sheetState) {
            BottomSheet(
                sheetState = bottomSheetState,
                pizza = pizza!!,
                onDismiss = {
                    sheetState = false
                }
            ) {

            }


        }


    }
}


@Composable
@Preview(showBackground = true)
fun DeliverySection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.DirectionsBike,
            contentDescription = "Star",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(30.dp)
                .padding(end = 2.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Free Delivery",
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
            modifier = Modifier,
            color = Color.Black.copy(0.6f)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "30 min",
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
            modifier = Modifier,
            color = Color.Black.copy(0.6f)
        )

    }

}

@Composable
fun RatingSection() {


    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        (1..5).forEach {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = "Star",
                tint = Color(0xffFFC107),
                modifier = Modifier.padding(end = 2.dp)
            )
        }


        // rating
        Text(
            text = "4.5 (20)",
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
            modifier = Modifier,
            color = Color.Black
        )
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderItem(
    title: String,
    value: Float,
    total: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$title ⭐",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier,
            color = Color.Black.copy(0.6f)
        )

        Slider(
            value = value,
            onValueChange = {},
            valueRange = 0f..100f,
            modifier = Modifier
                .weight(0.1f)
                .padding(0.dp),
            colors = SliderDefaults.colors(
                thumbColor = Color.Transparent,
                inactiveTickColor = Color.Transparent,
                activeTickColor = Color.Transparent,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.primary.copy(0.2f)
            ),
            thumb = {

            }
        )

        Text(
            text = "$total",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier,
            color = Color.Black.copy(0.6f)
        )
    }

}