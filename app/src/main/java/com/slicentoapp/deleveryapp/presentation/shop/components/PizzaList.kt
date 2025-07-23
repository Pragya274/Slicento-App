package com.slicentoapp.deleveryapp.presentation.shop.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddShoppingCart
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slicentoapp.deleveryapp.data.Pizza
import com.slicentoapp.deleveryapp.data.pizzas

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PizzaList(onClick: (Pizza) -> Unit) {


    val screenWidth = LocalConfiguration.current.screenWidthDp
    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
    ) {
        pizzas.forEach { pizza ->
            PizzaCard(
                pizza = pizza,
                modifier = Modifier
                    .width((screenWidth / 2).dp)
                    .padding(8.dp)
            ) {
                onClick(pizza)
            }
        }
    }
}

@Composable
fun PizzaCard(pizza: Pizza, modifier: Modifier, onClick: (Pizza) -> Unit) {

    ElevatedCard(
        onClick = { onClick(pizza) },
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier.shadow(
            elevation = 2.dp,
            shape = MaterialTheme.shapes.medium
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            // share button
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BoxWithConstraints(
                    modifier = Modifier.fillMaxWidth()
                ){
                    val maxWidth = maxWidth
                    Image(
                        painter = painterResource(id = pizza.image),
                        contentDescription = pizza.name,
                        modifier = Modifier.size(maxWidth)
                    )
                }


                Text(
                    text = pizza.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Normal
                    ),
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)

                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text =
                        "$${pizza.price}",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier,
                        color = Color.Black
                    )


                    Text(
                        text = "$${(pizza.price + 50f).toInt()}",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 4.dp),
                        color = Color.Black.copy(0.6f),
                        textDecoration = TextDecoration.LineThrough
                    )

                    // spacer
                    Box(modifier = Modifier.width(4.dp))

                    // discount

                    Badge(
                        modifier = Modifier
                            .wrapContentWidth(),
                        containerColor = Color(0xFF1C8100),
                        contentColor = Color.White
                    ) {
                        Text(
                            text = "-${100 - (pizza.price * 100 / (pizza.price + 50f)).toInt()}%",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(horizontal = 2.dp)
                        )
                    }


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {


                    // button
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Add to cart",
                            color = Color.White,
                            fontSize = 14.sp,
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier
                        )
                    }

                }


            }

            ElevatedCard(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 1.dp
                ),
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = "Share",
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(20.dp)
                )
            }

        }


    }


}