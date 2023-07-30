package com.example.budgettraveller.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


import com.example.budgettravelplan.R


@Composable
fun SplashScreen(navigationController: NavController){

    Box(modifier= Modifier.fillMaxSize()) {
        
        
        Image(painter = painterResource(id =R.drawable.splashtravel1), contentDescription ="null",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize())



        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                brush = Brush.linearGradient(

                        colors = listOf(Color.Red, Color.Blue),

                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "make your trip a memorable",
            fontFamily = FontFamily.Serif,
            )
            
            Text(text = "be happy",
            fontFamily = FontFamily.Serif,
            )

            
            Button(onClick = {
navigationController.navigate("home")
            },
            modifier= Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            )) {
               Text(text = "lets Start") 
            }

        }
    }
}




