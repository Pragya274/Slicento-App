package com.slicentoapp.deleveryapp.presentation.cart.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastCbrt
import com.slicentoapp.deleveryapp.data.Order
import com.slicentoapp.deleveryapp.data.orders


@Composable
@Preview(showBackground = true)
fun CartList() {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        orders.forEach {
            item {
                CartItem(order = it)
            }
        }
    }

}

@Composable
fun CartItem(order: Order) {
    var status by remember { mutableStateOf(false) }

    ElevatedCard(
        onClick = { },
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = Modifier.padding(vertical = 8.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = status, onCheckedChange = {
                    status = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,
                    uncheckedColor = MaterialTheme.colorScheme.onBackground
                )
            )



            Image(
                painter = painterResource(id = order.pizza.image),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit

            )

            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    text = order.pizza.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "Price: {order.pizza.price}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black.copy(0.4f),
                )

                Spacer(modifier = Modifier.padding(1.dp))

                Text(
                    text = "Quantity: {order.quantity}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black.copy(0.4f),
                )
                Spacer(modifier = Modifier.padding(1.dp))

                Text(
                    text = "Total: {order.pizza.price * order.quantity}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.padding(1.dp))


            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = null,
                    tint = Color(
                        0xffdd0000
                    )
                )
            }

        }
    }

}