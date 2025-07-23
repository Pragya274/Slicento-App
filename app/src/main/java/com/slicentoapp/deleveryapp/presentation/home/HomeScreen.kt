package com.slicentoapp.deleveryapp.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import com.slicentoapp.deleveryapp.presentation.home.components.BottomNavigation
import com.slicentoapp.deleveryapp.presentation.home.components.HomeTopBar
import com.slicentoapp.deleveryapp.presentation.home.components.SearchBar
import com.slicentoapp.deleveryapp.presentation.navigation.graph.AppGraph
import com.slicentoapp.deleveryapp.presentation.navigation.graph.HomeGraph
import com.slicentoapp.deleveryapp.presentation.order.OrdersScreen
import com.slicentoapp.deleveryapp.presentation.profile.ProfileScreen
import com.slicentoapp.deleveryapp.presentation.shop.ShopScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val state = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state
    )


    val route = remember {
        mutableStateOf<HomeGraph>(HomeGraph.Shop)
    }
    Scaffold(
        topBar = {
            HomeTopBar(content = {
                if (route.value == HomeGraph.Shop) {
                    SearchBar()
                }
            }, scrollBehavior){
                navController.navigate(AppGraph.Cart)
            }
        },
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                route = route.value
            ) {
                route.value = it
            }

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AnimatedVisibility(
                visible = true,
                enter = fadeIn(
                    animationSpec = tween(500)
                ) + slideInVertically(),
                exit = fadeOut(
                    animationSpec = tween(500)
                ) + slideOutVertically()
            ) {
                when (route.value) {

                    HomeGraph.Shop -> {
                        ShopScreen(appNavigation = navController)
                    }

                    HomeGraph.Profile -> {
                       ProfileScreen(appNavigation = navController)
                    }

                    HomeGraph.Order -> {
                        OrdersScreen(appNavigation = navController)
                    }
                }
            }


        }


    }


}