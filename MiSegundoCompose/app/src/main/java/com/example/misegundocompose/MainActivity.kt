package com.example.MiSegundoCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.misegundocompose.R
import com.example.misegundocompose.ui.theme.MiSegundoComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiSegundoComposeTheme {
                MiBoton()

                }
            }
        }
    }


@Composable
fun MiFuncion1(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Greeting(name = "Peter", modifier = Modifier.background(Color.Yellow))
        Greeting(name = "Android", modifier = Modifier.align(Alignment.BottomEnd).background(Color.Blue))
    }
}
@Composable
fun MiFuncion2(){
    Column(
        modifier = Modifier.fillMaxWidth().height(200.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Greeting(name = "Peter", modifier = Modifier.background(Color.Gray).weight(2f))
        //Greeting(name = "Android", modifier = Modifier.background(Color.Yellow))
        Greeting(name = "San Juan De La Cruz", modifier = Modifier.background(Color.Red).weight(1f))
    }
}
@Composable
fun MiFuncion3(){
    Row(modifier = Modifier.fillMaxWidth().height(200.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround){
        Greeting(name = "Peter", modifier = Modifier.background(Color.Gray))
        Greeting(name = "Juan", modifier = Modifier.background(Color.Green))
    }
}
//@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun MiBoton(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text="Pulsa Aqui", modifier = Modifier.background(Color.Green)
            .clickable{/*falta*/ }
            .border(width=2.dp,color=Color.Magenta)
            .padding(horizontal = 20.dp, vertical = 10.dp))
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

//@Preview(showBackground = true,name = "Peter Preview")
@Composable
fun MiFuncion1Preview(){
    MiSegundoComposeTheme {
        MiFuncion1()
    }
}
//@Preview(showBackground = true,name = "Peter Preview 2")
@Composable
fun MiFuncion2Preview(){
    MiSegundoComposeTheme {
        MiFuncion3()
    }
}
//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiSegundoComposeTheme {
        Greeting("Android")
    }
}

@Preview (showBackground = true, widthDp = 200, heightDp = 100, name = "Textos")
@Composable
fun Textos(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        Text(text = stringResource(id = R.string.lore),
            color = Color.Black,
            fontSize = 25.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Right,
            lineHeight = 2.em,
            maxLines = 1
        )

    }
}
