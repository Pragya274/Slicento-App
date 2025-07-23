package com.slicentoapp.deleveryapp.presentation.navigation.graph

import kotlinx.serialization.Serializable


sealed interface AppGraph {

    @Serializable
    data object OnBoarding : AppGraph

    @Serializable
    data object Home : AppGraph

    @Serializable
    data object Cart : AppGraph


    @Serializable
    data object Login : AppGraph

    @Serializable
    data object SignUp : AppGraph

    @Serializable
    data object ForgotPassword : AppGraph


    @Serializable
    data object OrderDetails : AppGraph

    @Serializable
    data class ProductDetails(val productId: Int): AppGraph


}


sealed interface HomeGraph{

    @Serializable
    data object Shop:HomeGraph

    @Serializable
    data object Order:HomeGraph

    @Serializable
    data object Profile:HomeGraph

}