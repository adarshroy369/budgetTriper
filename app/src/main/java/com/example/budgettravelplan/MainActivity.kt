package com.example.budgettravelplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.example.budgettraveller.Screens.DetailScreen
import com.example.budgettraveller.Screens.HomeScreen
import com.example.budgettraveller.Screens.SplashScreen

import com.example.budgettravelplan.ui.theme.BudgetTravelPlanTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetTravelPlanTheme {
              val navigationController = rememberNavController()



              ProvideWindowInsets {
                  Surface (modifier = Modifier.fillMaxSize(),
                      color = MaterialTheme.colors.background){

                      NavHost(navController =navigationController , startDestination = "splash", ) {
                          composable("splash"){
                              SplashScreen(navigationController = navigationController)
                          }

                          composable("home"){
                              HomeScreen(navigationController=navigationController)
                          }

                          composable("detail"){
                              DetailScreen(navigationController = rememberNavController())
                          }
                      }

                  }
              }
                  }
              }

    }
}


