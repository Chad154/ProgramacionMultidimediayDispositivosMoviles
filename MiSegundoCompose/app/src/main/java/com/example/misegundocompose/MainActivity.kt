package com.example.misegundocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.misegundocompose.ui.theme.MiSegundoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiSegundoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Chad",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, widthDp = 100, heightDp = 100, name = "PreviewBoton")
@Composable
fun miBoton(){
    Box(
        modifier = Modifier.size(20.dp).background(Color.Red, shape = CircleShape),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Pulsa Aqui",
            modifier = Modifier.background(Color.Yellow))

    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiSegundoComposeTheme {
        Greeting("Android")
    }
}

@Composable
fun Mifuncion1() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Greeting(
            name = "Chad",
            modifier = Modifier.background(Color.Yellow))
        Greeting(
            name = "Android",
            Modifier
                .align(alignment = Alignment.BottomEnd)
                .background(Color.Blue)
        )

    }
}

//@Preview(showBackground = true, name = "Chad")
@Composable
fun MiFuncion1Preview() {
    MiSegundoComposeTheme {
        Mifuncion1()
    }
}

@Composable
fun Mifuncion2(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        Greeting(
            name = "Antonio",
            modifier = Modifier
                .background(Color.Gray)
                .weight(1f)
        )
        Greeting(
            name = "Android",
            modifier = Modifier
                .background(Color.Yellow)
                .weight(2f)
        )
        /*Greeting(
            name = "San Juan de la Cruz",
            modifier = Modifier.background(Color.Magenta),

        )*/
    }
}

@Preview(showBackground = true, name = "Chad")
@Composable
fun MiFuncion2Preview(){
    Mifuncion2()
}

@Composable
fun MiFuncion3(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 200.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Greeting(
            name = "Roberto",
            modifier = Modifier.background(Color.Cyan)
        )

        Greeting(
            name = "Andy",
            modifier = Modifier.background(Color.LightGray)
        )



    }
}

@Preview (showBackground = true, name = "Chad")
@Composable
fun Mifuncion3Preview() {
    MiFuncion3()
}
