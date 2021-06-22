package com.android.compose.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.compose.PhotoPost
import com.android.compose.ui.theme.AndroidComposeTheme

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ListOfPhotos1(emptyList())
                }
            }
        }
    }
}

@Composable
private fun ListOfPhotos1(items: List<PhotoPost>) {
    LazyColumn {
        items(items.size) { index ->
            PostItem(items[index])
        }
    }
}

@Composable
private fun PostItem(post: PhotoPost) {
    Column {
        PostHeader(post)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            painter = painterResource(id = post.img),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
        PostBottom()
        Divider(color = Color.Gray)
    }
}

@Composable
private fun PostHeader(post: PhotoPost) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .size(36.dp)
                .border(1.dp, MaterialTheme.colors.primary, CircleShape)
                .clip(CircleShape),
            painter = painterResource(id = post.authorImg),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )

        Column {
            Text(
                text = post.author,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = post.location,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
private fun PostBottom(){
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
        ListOfPhotos1(emptyList())
    }
}