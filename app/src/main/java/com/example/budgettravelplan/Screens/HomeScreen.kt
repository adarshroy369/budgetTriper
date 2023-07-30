package com.example.budgettraveller.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BikeScooter
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.budgettraveller.data.BudgetTripModel
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun HomeScreen(navigationController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            HomeHeader()
        }
        item {
            Text(
                text = "Lovely vacation places",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(top = 24.dp, start = 12.dp, bottom = 8.dp)
            )
        }

        itemsIndexed(trips) { position, data ->
HoneyTripItem(budgetTripModel = data,navigationController = navigationController)
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }

    }
}




@Composable
fun HomeHeader(){
    Box() {
        Image(painter = painterResource(id = com.example.budgettravelplan.R.drawable.head),
            contentDescription = null,
        modifier = Modifier
            .height(260.dp)
            .fillMaxWidth(), contentScale = ContentScale.Crop)
        
        
        Column(modifier= Modifier
            .align(Alignment.TopCenter)
            .padding(top = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
            
            Text(text = "welcome to honeymoon trip",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            style = TextStyle(shadow = Shadow(color = Color.White, blurRadius = 6f))
           
            )
            
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {

                VectorButton(vector = Icons.Default.Flight, text = "flight")
                VectorButton(vector = Icons.Default.CarCrash, text = "car")
                VectorButton(vector = Icons.Default.BikeScooter, text = "bike")
            }

            }
            
            
        }

    }



@Composable
fun VectorButton(vector:ImageVector,text:String) {
    Button(onClick = { },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                imageVector = vector , contentDescription = " ")

            Text(text = text, style = TextStyle(
                fontSize = 14.sp
            ))

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}



@Composable
fun HoneyTripItem(budgetTripModel: BudgetTripModel,navigationController: NavController){
    
    Column(modifier= Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)) {

//val budgetTripModel:Painter= painterResource(id = budgetTripModel.image)

        Image(painter = painterResource(id = budgetTripModel.image),
            contentDescription =null ,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    navigationController.navigate("detail")


                }


                .height(200.dp)
                .fillMaxWidth())
        
        
        Spacer(modifier = Modifier.height(8.dp))
        
        
        Row {
            Text(text= budgetTripModel.dayPerson,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )


            Spacer(modifier = Modifier.weight(1f))


            Icon(imageVector = Icons.Default.Home,
                contentDescription = " ",
                tint = Color(255,215,0),
                modifier= Modifier
                    .padding(4.dp)
                    .size(12.dp)
                    .align(CenterVertically)
                )



            Text(text =budgetTripModel.experience.toString(),
                fontFamily = FontFamily.Serif,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 24.sp
            )


        }


    }
}




val trips = listOf<BudgetTripModel>(
    BudgetTripModel(
      com.example.budgettravelplan.R.drawable.beach,
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ), BudgetTripModel(
        com.example.budgettravelplan.R.drawable.splashtravel1,
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ), BudgetTripModel(
        com.example.budgettravelplan.R.drawable.head,
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ), BudgetTripModel(
        com.example.budgettravelplan.R.drawable.aa,
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ), BudgetTripModel(
        com.example.budgettravelplan.R.drawable.bb,
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ), BudgetTripModel(
        com.example.budgettravelplan.R.drawable.ccc,
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ), BudgetTripModel(
        com.example.budgettravelplan.R.drawable.ddd,
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2022",
        4.8f
    ),


    )




@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navigationController = rememberNavController())
}




