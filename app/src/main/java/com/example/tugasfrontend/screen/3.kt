package com.example.tugasfrontend.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tugasfrontend.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun me(navController: NavHostController){
    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFFFE1AFD1)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    IconButton(onClick = {navController.navigate("1") }) {
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
                    Text(text = "About me",
                        color = Color.White)
                }
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFFE1AFD1)
                )
            )
        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Box(modifier = Modifier.fillMaxWidth(),
                Alignment.TopCenter){
                Image(painter = painterResource(id = R.drawable.foto),
                    contentDescription ="foto",
                    modifier = Modifier.size(400.dp))
            }
            Text(text = "Nama : Denisa Alifiantoro Putri Diningrat",
                fontSize = 20.sp)

            Text(text = "Email : denisaalifian@gmail.com",
                fontSize = 20.sp)
            Text(text = "Perguruan : Politeknik Negeri Jakarta",
                fontSize = 20.sp)
            Text(text = "Jurusan : Teknik Grafika Penerbitan",
                fontSize = 20.sp)

        }

    }
}