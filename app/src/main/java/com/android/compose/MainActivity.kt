package com.android.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.compose.ui.theme.AndroidComposeTheme

private val photoPosts = listOf(
    PhotoPost(0, "Andy Taylor", R.drawable.ali, "Kim Jong-un str., North Korea", R.drawable.ali),
    PhotoPost(1, "Chelsea FC", R.drawable.chelsea_fc_avatar, "London, UK", R.drawable.chelsea_fc),
    PhotoPost(2, "Pltsci", R.drawable.psci, "47 Fulham Road, CA, USA", R.drawable.psci_img),
    PhotoPost(
        3,
        "Lemberg Solution",
        R.drawable.lemberg_avatar,
        "Lviv, Ukraine",
        R.drawable.lemberg_img
    ),
    PhotoPost(0, "Andy Taylor", R.drawable.ali, "North Kore", R.drawable.ali),
    PhotoPost(
        4,
        "Lemberg Solution",
        R.drawable.lemberg_avatar,
        "Lviv, Ukraine",
        R.drawable.lemberg_imgg
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ListOfItems()
                }
            }
        }
    }
}

@Composable
private fun ListOfItems(params: List<PhotoPost> = photoPosts) {
    LazyColumn() {
        items(params.size) {index->
            Item(photoPosts[index])
        }
    }
}

@Composable
private fun Item(item:PhotoPost) {
    Column {
        Header(item)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(id = item.img),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Bottom()
    }
}

@Composable
private fun Header(item:PhotoPost) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .size(36.dp)
                .border(1.dp, MaterialTheme.colors.primary, CircleShape)
                .clip(CircleShape),
            painter = painterResource(id = item.authorImg), contentDescription = null
        )

        Column() {
            Text(text = item.author, style = MaterialTheme.typography.subtitle1)
            Text(text = item.location, style = MaterialTheme.typography.caption)
        }
    }
}

@Composable
private fun Bottom() {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Icon(
            Icons.Outlined.FavoriteBorder,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp),
            contentDescription = null
        )
        Icon(
            Icons.Outlined.ChatBubbleOutline,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp),
            contentDescription = null
        )
        Icon(
            Icons.Outlined.Share,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidComposeTheme {
        ListOfItems()
    }
}
