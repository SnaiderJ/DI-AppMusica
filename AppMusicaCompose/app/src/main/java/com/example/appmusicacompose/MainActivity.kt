package com.example.appmusicacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appmusicacompose.ui.theme.AppMusicaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMusicaComposeTheme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppMusica() {
    AppMusicaComposeTheme {

    }
}