/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.storedatasample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.storedatasample.presentation.theme.StoredatasampleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalWearMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }


    }
}

object NavRoute {
    const val SCREEN_2 = "screen2"
    const val SCREEN_3 = "screen3"

}
@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun WearApp() {

    val navController = rememberSwipeDismissableNavController()
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = NavRoute.SCREEN_2
    ) {

        composable(NavRoute.SCREEN_2) {
            Screen2(navController)
        }
        composable(NavRoute.SCREEN_3) {
            Screen3(navController)
        }
    }



}

@Composable
fun Screen2(navigation: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hello Android Compose!", textAlign = TextAlign.Center)
        Button(onClick = { navigation.navigate("screen3") }) {
            Text("Button")
        }
    }
}

@Composable
fun Screen3(navigation: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hello Android Compose Navigate to Page 2!", textAlign = TextAlign.Center)
        Button(onClick = { navigation.navigate("screen2") }) {
            Text("Button")
        }
    }
}
//@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true )
//@Composable
//fun DefaultPreview() {
//  WearApp("Preview Android", NavController())
//}