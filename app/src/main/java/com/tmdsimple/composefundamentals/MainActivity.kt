package com.tmdsimple.composefundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tmdsimple.composefundamentals.ui.theme.ComposeFundamentalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageDemo()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "$name!",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Cyan)
            .border(3.dp, color = Color.Yellow)
            .padding(10.dp)
    )
}

@Composable
fun ImageDemo(){
    val imageModifier = Modifier
        .size(150.dp)
        .border(BorderStroke(1.dp, Color.Black),
                CircleShape)
        .clip(CircleShape)

    Row(modifier = Modifier.padding(18.dp)){
        Image(painter = painterResource(id = R.drawable.mycat),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier)
        Column(modifier = Modifier.padding(8.dp)) {
            Text("This is my cat", color = Color.Blue, fontWeight = FontWeight.Bold )
            Text("His color is white and brown")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeFundamentalsTheme {
        Column(modifier = Modifier
            .fillMaxHeight()
            .background(color = Color.LightGray),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
                        ) {
            ImageDemo()
            Greeting("Android 123")
            Greeting("Jetpack Compose")
            Greeting("Compose 123")
        }

    }
}