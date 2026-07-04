package com.example.appmarket.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appmarket.ui.screens.Screens
import com.example.appmarket.ui.screens.cartScreen.CartScreen
import com.example.appmarket.ui.screens.MainScreen.MainScreen
import com.example.appmarket.ui.screens.productScreen.ProductDetailScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ){
        composable(route = Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screens.CartScreen.route){
            CartScreen()
        }
        composable(
            route = Screens.ProductDetail.route,
            arguments = listOf(navArgument("productId"){type = NavType.IntType})
        ){ backStackEntry ->
            val id = backStackEntry.arguments?.getInt("productId") ?: 0

            ProductDetailScreen(
                productId = id,
                onBackClick = { navController.popBackStack()}
            )
        }
    }
}