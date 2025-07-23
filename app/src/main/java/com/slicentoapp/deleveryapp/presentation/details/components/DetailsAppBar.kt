package com.slicentoapp.deleveryapp.presentation.details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsAppBar(title: String, scrollBehavior: TopAppBarScrollBehavior, onBack: () -> Unit) {

    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(text = title)
        },
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .drawBehind {
                // draw shadow
                val shadowColor = Color.Black.copy(alpha = 0.2f)
                val shadowOffset = 1.dp.toPx()

                drawRect(
                    color = shadowColor,
                    topLeft = Offset(0f, size.height - shadowOffset),
                    size = Size(size.width, shadowOffset)
                )
            },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = androidx.compose.material3.MaterialTheme.colorScheme.background,
            titleContentColor = Color.Black,
            navigationIconContentColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
            actionIconContentColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
            scrolledContainerColor = androidx.compose.material3.MaterialTheme.colorScheme.background
        ),

        navigationIcon = {
            IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = "Back"
                )
            }

            BadgedBox(badge = {
                Badge(
                    modifier = Modifier,
                    containerColor = Color.Red,
                    contentColor = Color.White
                ){
                    Text(text = "3")
                }
            },
                modifier = Modifier.padding(end = 8.dp)) {
                Icon(
                    imageVector = Icons.Rounded.ShoppingCart,
                    contentDescription = "Back"
                )
            }


        }

    )
}