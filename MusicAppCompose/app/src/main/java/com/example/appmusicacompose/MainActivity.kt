package com.example.appmusicacompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmusicacompose.ui.theme.AppMusicaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMusicaComposeTheme {
                AppMusicaEstado()
            }
        }
    }
}

@Composable
fun SimpleContinuousSlider(valor: Float) {
    val range = 0f..100f
    var selection by remember { mutableFloatStateOf(valor) }
    Slider(
        modifier = Modifier.width(250.dp),
        value = selection,
        valueRange = range,
        onValueChange = { selection = it }
    )
}

//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    device = "id:pixel_8_pro"
//)
@Preview(
    showSystemUi = true,
    device = "spec:width=448dp,height=998dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun AppMusicaEstado() {
    var reproduciendo by rememberSaveable { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            AppMusicaHorizontal(reproduciendo) { nuevoEstado ->
                reproduciendo = nuevoEstado
            }
        }

        else -> {
            AppMusicaVertical(reproduciendo) { nuevoEstado ->
                reproduciendo = nuevoEstado
            }
        }
    }
}

@Composable
fun AppMusicaVertical(reproduciendo: Boolean, onReproduciendoChange: (Boolean) -> Unit) {
    AppMusicaComposeTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.descarga),
                contentDescription = "imagen",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(425.dp, 500.dp),
            )
            Text("La 5º Sinfonia", style = MaterialTheme.typography.titleLarge)
            Text("Ludwig van Beethoven", style = MaterialTheme.typography.titleLarge)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("1:25", style = MaterialTheme.typography.titleLarge)
                SimpleContinuousSlider(25f)
                Text("3:25", style = MaterialTheme.typography.titleLarge)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.atras),
                        contentDescription = "atras",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(40.dp)
                    )
                }
                Button(
                    onClick = {
                        onReproduciendoChange(!reproduciendo)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(
                            if (reproduciendo)
                                R.drawable.pause
                            else
                                R.drawable.play
                        ),
                        contentDescription = "play",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(80.dp)
                    )
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.adelante),
                        contentDescription = "adelante",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.volumen),
                        contentDescription = "volumen",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(40.dp)
                    )
                }
                SimpleContinuousSlider(70f)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.compartir),
                        contentDescription = "compartir",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.letra),
                        contentDescription = "letra",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.lista_canciones),
                        contentDescription = "lista de canciones",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AppMusicaHorizontal(reproduciendo: Boolean, onReproduciendoChange: (Boolean) -> Unit) {
    AppMusicaComposeTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(R.drawable.descarga),
                    contentDescription = "imagen",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(500.dp, 350.dp)
                )
                Text("La 5º Sinfonia", style = MaterialTheme.typography.titleLarge)
                Text("Ludwig van Beethoven", style = MaterialTheme.typography.titleMedium)
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("1:25", style = MaterialTheme.typography.titleLarge)
                    SimpleContinuousSlider(25f)
                    Text("3:25", style = MaterialTheme.typography.titleLarge)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.atras),
                            contentDescription = "atras",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Button(
                        onClick = {
                            onReproduciendoChange(!reproduciendo)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(
                                if (reproduciendo)
                                    R.drawable.pause
                                else
                                    R.drawable.play
                            ),
                            contentDescription = "play",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(80.dp)
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.adelante),
                            contentDescription = "adelante",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.volumen),
                            contentDescription = "volumen",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    SimpleContinuousSlider(70f)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.compartir),
                            contentDescription = "compartir",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.letra),
                            contentDescription = "letra",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lista_canciones),
                            contentDescription = "lista de canciones",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }
        }
    }
}
