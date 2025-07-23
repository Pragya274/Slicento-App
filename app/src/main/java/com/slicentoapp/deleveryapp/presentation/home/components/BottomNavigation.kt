package com.slicentoapp.deleveryapp.presentation.home.components


import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.slicentoapp.deleveryapp.presentation.navigation.graph.AppGraph
import com.slicentoapp.deleveryapp.presentation.navigation.graph.HomeGraph
import com.slicentoapp.deleveryapp.ui.theme.Orange40


@Composable
fun BottomNavigation(
    route: HomeGraph,
    onClick: (HomeGraph) -> Unit = {}
) {

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.primary,
        tonalElevation = 16.dp,
        modifier = Modifier.drawBehind {
            drawLine(
                color = Color.Gray,
                start = Offset.Zero,
                end = Offset(size.width, 0f),
                strokeWidth = 3f,
            )
        }
    ) {
        list.forEach { item ->


            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.route.toString()
                    )
                },
                label = {
                    Text(
                        text = item.route.toString(),
                        fontWeight = if (route == item.route) FontWeight.Bold else FontWeight.Normal,
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier.then(
                    if (route == item.route) {
                        Modifier.drawBehind {
                            drawLine(
                                color = Orange40,
                                start = Offset(80f, 0f),
                                end = Offset(size.width - 80f, 0f),
                                strokeWidth = 30f,
                                cap = StrokeCap.Round,
                                blendMode = BlendMode.SrcAtop
                            )
                        }
                    } else {
                        Modifier
                    }

                ),
                selected = if (route == item.route) true else false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.primary.copy(0.2f),
                    unselectedIconColor = Color.Black.copy(0.6f),
                    unselectedTextColor = Color.Black.copy(0.6f),
                ),
                onClick = {
                    onClick(item.route)
                }
            )
        }


    }

}

data class BottomNavigationItem(
    val route: HomeGraph,
    val icon: ImageVector
)


val list = listOf(
    BottomNavigationItem(HomeGraph.Shop, Icons.Rounded.Home),
    BottomNavigationItem(HomeGraph.Order, Icons.Rounded.History),
    BottomNavigationItem(HomeGraph.Profile, Icons.Rounded.AccountCircle),
)