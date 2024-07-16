package com.example.igclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen( modifier: Modifier = Modifier){
    Column( modifier = Modifier.fillMaxSize()) {
        TopAppBar(name = "g_nguyai", modifier =  Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        ProfileDescription(
            displayName = "Programming Mentor",
            description = "Bit by bit",
            url = "Http//:WWW.working.onit.com",
            follwedBy = listOf("coding flow", "MiaKhalifa"),
            otherCount = 17
        )
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection()
        Spacer(modifier = Modifier.height(25.dp))
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
            modifier = Modifier.size(30.dp)
        )
    }
}

/**
 * Profile area
 */
@Composable
fun ProfileSection(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ){
            RoundImage(image = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatsSection(modifier = Modifier.weight(7f))
        }
    }
}
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true,
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}
/**
 * Stats Section
 */
@Composable
fun StatsSection(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    )
    {
        ProfileStats(numberText = "6001", text = "Posts")
        ProfileStats(numberText = "60 K", text = "Followers")
        ProfileStats(numberText = "1", text = "Following")
    }
}
@Composable
fun ProfileStats(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
Text(
    text = numberText,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,

        )
    }
}

/**
 * Profile description
 */
@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    follwedBy: List<String>,
    otherCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)){
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color =  Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(follwedBy.isNotEmpty()){
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed by")
                pushStyle(boldStyle)
                follwedBy.forEachIndexed{index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if(index < follwedBy.size -1){
                        append(",")
                    }
                }
                if (otherCount > 2){
                    append(" and ")
                    pushStyle(boldStyle)
                    append(" $otherCount others")
                }
            },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}
/**
 * Action Button section
 */
@Composable
fun ButtonSection( modifier: Modifier = Modifier){
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ){
        ActionButton(text = " Following", icon = Icons.Default.KeyboardArrowDown, modifier = Modifier
            .defaultMinSize(minWidth = minWidth)
            .height(height))
        ActionButton(text = " Message", modifier = Modifier
            .defaultMinSize(minWidth = minWidth)
            .height(height))
        ActionButton(text = " Email", modifier = Modifier
            .defaultMinSize(minWidth = minWidth)
            .height(height))
        ActionButton( icon = Icons.Default.KeyboardArrowDown, modifier = Modifier.size(height))
    }
}
/**
 * Action Buttons
 */
@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.border(
            width = 1.dp,
            color = Color.LightGray,
            shape = RoundedCornerShape(5.dp)
        )
    ){
        if (text != null){
         Text(
             text = text,
             fontWeight = FontWeight.SemiBold,
             fontSize = 14.sp
         )
        }
        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
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