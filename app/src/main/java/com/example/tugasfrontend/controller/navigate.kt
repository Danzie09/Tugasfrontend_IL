package com.example.tugasfrontend.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasfrontend.data.detailgambar
import com.example.tugasfrontend.data.gambar
import com.example.tugasfrontend.data.nama
import com.example.tugasfrontend.screen.detail
import com.example.tugasfrontend.screen.grid
import com.example.tugasfrontend.screen.lazy
import com.example.tugasfrontend.screen.me

@Composable
fun Navigate(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "1") {

        composable(route = "1") {
            lazy(navController)
        }
        composable(route = "2") {
            grid(navController)
        }
        composable(route = "3") {
            me(navController)
        }
        composable(route = "detail/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            detail(photos = gambar,
                name = nama,
                ingridients = detailgambar,
                itemIndex = index.arguments?.getInt("index"),
                navController
            )
        }
    }
}