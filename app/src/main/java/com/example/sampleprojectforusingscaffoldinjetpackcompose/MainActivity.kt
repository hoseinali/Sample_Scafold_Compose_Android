package com.example.sampleprojectforusingscaffoldinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleprojectforusingscaffoldinjetpackcompose.ui.theme.SampleProjectForUsingScaffoldInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleProjectForUsingScaffoldInJetpackComposeTheme {
                    MyScaffoldApp()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldApp() {
    val items = listOf("Home", "Search", "Profile")
    var selectedItem = remember { mutableStateOf(items[0]) }

    Scaffold(
        //1
        topBar = {
            TopAppBar(title = {Text("My Beautiful App")},
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu Icon")
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color(0xFF6200EE),
                    titleContentColor = Color.White,
                    scrolledContainerColor = Color(0xFF3700B3),
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ))
        },
        //2
        bottomBar = {
            NavigationBar {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color(0xFF6200EE)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    items.forEach { item ->
                        val isSelected = selectedItem.value == item
                        IconButton(
                            onClick = { selectedItem.value = item },
                            modifier = Modifier.weight(1f)
                        ) {
                            val icon = when (item) {
                                "Home" -> Icons.Filled.Home
                                "Search" -> Icons.Filled.Search
                                "Profile" -> Icons.Filled.AccountCircle
                                else -> Icons.Filled.Home
                            }
                            Icon(
                                imageVector = icon,
                                contentDescription = item,
                                tint = if (isSelected) Color.White else Color.Gray
                            )
                        }
                    }
                }
            }
        },
        //3
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                containerColor = Color(0xFF03DAC5)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add Icon",
                    tint = Color.White
                )

            }
        } ,
        //4
        floatingActionButtonPosition = FabPosition.End,
        //5
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(Color(0xFFFEAC5E), Color(0xFFC779D0), Color(0xFF4BC0C8)),
                            start = Offset(0f, 0f),
                            end = Offset(1000f, 1000f)
                        )
                    )
            ) {
                Text(
                    text = "Welcome to the Scaffold Layout!",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color(0xFF0D47A1)
                )
            }

        })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleProjectForUsingScaffoldInJetpackComposeTheme {
        MyScaffoldApp()
    }
}