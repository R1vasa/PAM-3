package com.example.pam4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pam4.ui.theme.PAM4Theme


class MainActivity : ComponentActivity() {
    val gadgets = listOf(
        Gadget(1, R.drawable.rafi, "Muhammad Rafi Hasbi Saviar"),
        Gadget(2, R.drawable.ijal, "Mifzal Arif Maulana"),
        Gadget(3, R.drawable.kharan, "Kharan Naethan Nizam"),
        Gadget(4, R.drawable.erla, "Erlangga Tri Frasdianto Idaman"),
        Gadget(5, R.drawable.aldrin, "Naufal Aldrin Danita"),
        Gadget(6, R.drawable.putu, "Putu Ananda Primadi Sari Putra"),
        Gadget(7, R.drawable.farrel, "Farrel Raditya"),
        Gadget(8, R.drawable.razzan, "Razzan Azizi Putra"),
        Gadget(9, R.drawable.doko, "Muhammad Tengoku Rayhandoko"),
        Gadget(10, R.drawable.armen, "Muhammad Murfid Kharomen"),
        Gadget(12, R.drawable.kiki, "Zaskia Fitri Nur Azizah"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            lazyColumn(gadgets)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun lazyColumn(gadgets: List<Gadget>) {
    LazyColumn() {
        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(color = Color.LightGray)
                    .statusBarsPadding(),
                verticalArrangement = Arrangement.Center
                ,horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(text = "Muhammad Rafi Hasbi Saviar", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "245150401111014")
            }
        }
        items(gadgets) { gadget ->
            GadgetItem(gadget)
        }
    }
}

@Composable
fun GadgetItem(gadget: Gadget) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp)) {
        Row(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
            Image(
                painter = painterResource(gadget.img),
                contentDescription = gadget.name,
                modifier = Modifier.size(80.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(10.dp))
            Text(text = gadget.name, style = MaterialTheme.typography.titleMedium)
        }
    }
}