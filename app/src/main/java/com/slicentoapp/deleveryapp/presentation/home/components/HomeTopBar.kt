package com.slicentoapp.deleveryapp.presentation.home.components

import android.widget.ImageButton
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    content: @Composable () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    onCartClick:()->Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val shadowColor = Color.Black.copy(alpha = 0.2f)
                val shadowOffset = 1.dp.toPx()

                drawRect(
                    color = shadowColor,
                    topLeft = Offset(0f, size.height - shadowOffset),
                    size = Size(size.width, shadowOffset)
                )
            }
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Slicento Delevery App",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold
                    ),

                    )
            }, scrollBehavior = scrollBehavior, modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth(), actions = {


                    IconButton(onClick = {  }) {
                        BadgedBox(badge = {
                            Badge(
                                containerColor = Color.Red,
                                contentColor = MaterialTheme.colorScheme.onPrimary
                            ){
                                Text(text = "2")
                            }
                        }, modifier = Modifier.padding(end = 16.dp)) {
                            Icon(
                                imageVector = Icons.Rounded.Notifications,
                                contentDescription = "Search",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }


                IconButton(onClick = { onCartClick()}) {
                    BadgedBox(badge = {
                        Badge(
                            containerColor = Color.Red,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ){
                            Text(text = "4")
                        }
                    }, modifier = Modifier
                        .padding(end = 16.dp)
                        ) {
                        Icon(
                            imageVector = Icons.Rounded.ShoppingCart,
                            contentDescription = "Search",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }




            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = MaterialTheme.colorScheme.primary,
                actionIconContentColor = MaterialTheme.colorScheme.primary,
                navigationIconContentColor = MaterialTheme.colorScheme.primary,
                scrolledContainerColor = MaterialTheme.colorScheme.background
            )
        )

        content()
    }


}