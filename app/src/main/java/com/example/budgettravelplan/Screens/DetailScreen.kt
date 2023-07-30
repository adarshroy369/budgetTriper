package com.example.budgettraveller.Screens

import android.widget.ExpandableListView.OnChildClickListener
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.budgettraveller.data.TripDetail
import com.example.budgettravelplan.R


@Composable
fun DetailScreen(navigationController:NavController){
    LazyColumn(){
item { 
TripDetailScreenHeader(navigationController = navigationController)
    TripInfoContent()
}
        itemsIndexed(tripDetail){position,data ->
            TripDetailContent(tripDetail = data)
            
        }
    }
}



@Composable
fun TripDetailScreenHeader(navigationController: NavController){
    Box {

        Image(
            painter = painterResource(id = R.drawable.beach),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()


        ) {
            CustomButton(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp),
            ) {
                navigationController.popBackStack()
            }

            CustomButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                imageVector = Icons.Default.BookmarkBorder,
            ) {

            }
        }
    }
}





@Composable
fun TripDetailContent(tripDetail: TripDetail){

    Column(
        modifier= Modifier.padding(horizontal = 16.dp, vertical = 8.dp).background(Color.Transparent)
    ) {
        Text(text = tripDetail.title.uppercase(),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = 18.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = tripDetail.detail,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )
    }



}





@Composable
fun CustomButton(
    imageVector: ImageVector,
    modifier:Modifier,
    clickListener: () -> Unit
) {
    Button(
        onClick = { clickListener() },
        border = BorderStroke(2.dp, Color(0xFFAFBFF)),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFAFBFF),
            contentColor = Color(0xFFAFBFF),

            ),
        modifier = modifier.then(Modifier.size(48.dp))

    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = " "
        )
    }
}




@Composable
fun LocationChip(text:String){


    Row (modifier= Modifier
        .clip(RoundedCornerShape(6.dp))
        .background(Color(0xFFAFBFF))
        .padding(
            horizontal = 8.dp,
            vertical = 2.dp
        )){



        Icon(imageVector = Icons.Default.LocationOn,
            contentDescription ="",
            modifier= Modifier
                .padding(end = 4.dp)
                .size(12.dp)
                .align(CenterVertically))




        Text(text = text
            , fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.Black)


    }
}




@Composable
fun TripDataItem(imageVector: ImageVector,title:String,subtitle:String){
    Row {
        Icon(modifier= Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .size(32.dp)
            .padding(8.dp),
            imageVector= imageVector,
            contentDescription = " "
        )



        Column {
            Text(text = title,
                fontFamily = FontFamily.Serif,
                fontWeight= FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}






@Composable
fun TripInfoContent(){
    Column(modifier= Modifier.padding(16.dp)) {
        Row {
            LocationChip(text = "North SHore")
            Spacer(modifier = Modifier.weight(1f))
            
            Icon(imageVector = Icons.Default.Star,
                contentDescription = "",
                modifier= Modifier
                    .padding(end = 8.dp)
                    .size(12.dp)
                    .align(CenterVertically),
                tint = Color(0xFFAFBFF)
            )
            
            Text(text = "3.8",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        
        Text(text = "How to get around North Shore on a cheap budget in 2022",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp,
            letterSpacing = (-0.2).sp
        )


        Divider(
            color = Color(0xFF191972),
            modifier = Modifier.padding(8.dp)
        )

        Row(modifier= Modifier.background(Color.LightGray),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            TripDataItem(
                imageVector = Icons.Default.CalendarToday,
                title = "Duration",
                subtitle = "7 days"
            )

            TripDataItem(
                imageVector = Icons.Default.Person,
                title = "Package For",
                subtitle = "2 Person"
            )

            TripDataItem(
                imageVector = Icons.Default.AttachMoney,
                title = "Total Cost",
                subtitle = "800"
            )

        }

        Divider(
            color = Color(0xFF232396),
            modifier = Modifier.padding(8.dp)
        )

    }
    }
    
    



var tripDetail = listOf(

    TripDetail(
        title = "Day 1: Bangkok",
        detail = "Our Thailand itinerary starts in Bangkok. This is the capital city of Thailand and where most international travelers will arrive in the country.\n" +
                "I recommend you allocate 3 days to explore. This will give you time to adjust to the climate and any time difference. It will also give you time to sightsee in the city itself, and also to take a day trip to a nearby UNESCO world heritage site. More on that shortly. First, let’s look at what you should get up to in Bangkok."
    ),
    TripDetail(
        title = "Day 2: Bangkok",
        detail = "Our Thailand itinerary starts in Bangkok. This is the capital city of Thailand and where most international travelers will arrive in the country.\n" +
                "I recommend you allocate 3 days to explore. This will give you time to adjust to the climate and any time difference. It will also give you time to sightsee in the city itself, and also to take a day trip to a nearby UNESCO world heritage site. More on that shortly. First, let’s look at what you should get up to in Bangkok."
    ),
    TripDetail(
        title = "Day 3: Bangkok",
        detail = "Our Thailand itinerary starts in Bangkok. This is the capital city of Thailand and where most international travelers will arrive in the country.\n" +
                "I recommend you allocate 3 days to explore. This will give you time to adjust to the climate and any time difference. It will also give you time to sightsee in the city itself, and also to take a day trip to a nearby UNESCO world heritage site. More on that shortly. First, let’s look at what you should get up to in Bangkok."
    ),
    TripDetail(
        title = "Day 4: Bangkok",
        detail = "Our Thailand itinerary starts in Bangkok. This is the capital city of Thailand and where most international travelers will arrive in the country.\n" +
                "I recommend you allocate 3 days to explore. This will give you time to adjust to the climate and any time difference. It will also give you time to sightsee in the city itself, and also to take a day trip to a nearby UNESCO world heritage site. More on that shortly. First, let’s look at what you should get up to in Bangkok."
    ),
    TripDetail(
        title = "Day 5: Bangkok",
        detail = "Our Thailand itinerary starts in Bangkok. This is the capital city of Thailand and where most international travelers will arrive in the country.\n" +
                "I recommend you allocate 3 days to explore. This will give you time to adjust to the climate and any time difference. It will also give you time to sightsee in the city itself, and also to take a day trip to a nearby UNESCO world heritage site. More on that shortly. First, let’s look at what you should get up to in Bangkok."
    ),

)












@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(navigationController = rememberNavController())
}