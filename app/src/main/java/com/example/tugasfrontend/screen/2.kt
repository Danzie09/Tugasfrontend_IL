package com.example.tugasfrontend.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasfrontend.data.gambar
import com.example.tugasfrontend.data.nama

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun grid(navController: NavHostController){
    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFFFE1AFD1)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    IconButton(onClick = { navController.navigate("1")}) {
                        Icon(imageVector = Icons.Default.Home,
                            contentDescription = "",
                            modifier = Modifier.size(30.dp))
                    }
                    IconButton(onClick = {navController.navigate("2") }) {
                        Icon(imageVector = Icons.Default.List,
                            contentDescription = "",
                            modifier = Modifier.size(30.dp))
                    }
                    IconButton(onClick = {navController.navigate("3") }) {
                        Icon(imageVector = Icons.Default.AccountCircle,
                            contentDescription = "",
                            modifier = Modifier.size(30.dp))
                    }
                }
            }
        },
        topBar ={
            TopAppBar(title = {
                Box(modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center){
                    Text(text = "screen2",
                        color = Color.White)
                }
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFFE1AFD1)
                )
            )
        }
    ){
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            val ItemCount = gambar.size
            items(ItemCount){item ->
                lazyitem(
                    itemIndex = item,
                    painter = gambar,
                    tittle = nama,
                    navController = navController

                )
            }
        }
    }
}

@Composable
fun lazyitem(itemIndex: Int,
             painter: Array<Int>,
             tittle: Array<String>,
             navController: NavHostController) {
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        .clickable {navController.navigate(route = "detail/$itemIndex") }
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(5.dp)) {
        Column(modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = tittle[itemIndex],
                modifier = Modifier.size(100.dp)
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = tittle[itemIndex],
                    fontSize = 15.sp
                )
            }
        }
    }

}
