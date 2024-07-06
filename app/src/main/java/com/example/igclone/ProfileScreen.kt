package com.example.igclone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen( modifier: Modifier = Modifier){
    Column( modifier = Modifier.fillMaxSize()) {
        TopAppBar(name = "g_nguyai")
        Spacer(modifier = Modifier.height(4.dp))
    }
}

/**
 * instangram top app bar
 */
@Composable
fun TopAppBar(name: String, modifier: Modifier = Modifier){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Arrow",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Back Arrow",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Back Arrow",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}
@Composable
fun ProfileSection(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxWidth()) {
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)){

        }
    }
}

/**
 * Instagram Clone Preview
 */
@Preview(showBackground = true)
@Composable
fun InstagramClonePreview(){
    ProfileScreen() 
}