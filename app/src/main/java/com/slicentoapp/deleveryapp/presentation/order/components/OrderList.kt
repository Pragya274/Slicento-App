package com.slicentoapp.deleveryapp.presentation.order.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slicentoapp.deleveryapp.data.Order
import com.slicentoapp.deleveryapp.data.orders


@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview(showBackground = true)
fun OrderList()
{
    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
        
    ) {

        orders.forEach {
            OrderItem(order = it){

            }
        }

    }
}


@Composable
fun OrderItem(order: Order, onClick: () -> Unit) {

    ElevatedCard(onClick = onClick,
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Image(
                painter = painterResource(id = order.pizza.image),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Fit
            )


            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ){

                Text(
                    text = order.pizza.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "Price: ${order.pizza.price}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black.copy(0.4f),
                )

                Spacer(modifier = Modifier.padding(1.dp))

                Text(
                    text = "Quantity: ${order.quantity}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black.copy(0.4f),
                )
                Spacer(modifier = Modifier.padding(1.dp))

                Text(
                    text = "Total: ${order.pizza.price * order.quantity}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.padding(1.dp))



            }

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                // delete button
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Rounded.Delete,
                        contentDescription = null,
                        tint = Color(
                            0xffdd0000
                        )
                    )
                }
                Spacer(modifier = Modifier.padding(1.dp))
                IconButton(onClick = { /*TODO*/ }) {
                   Icon(
                       imageVector = Icons.Rounded.Refresh,
                       contentDescription = null,
                       tint = MaterialTheme.colorScheme.primary

                   )
                }

            }
        }


    }

}