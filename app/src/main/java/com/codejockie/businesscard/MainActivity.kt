package com.codejockie.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codejockie.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xffd2e8d3))
            .padding(32.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PhotoInfo()
        Spacer(modifier = Modifier.height(200.dp))
        ContactDetails()
    }
}

@Composable
fun PhotoInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = stringResource(R.string.profile_picture),
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 36.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = stringResource(R.string.job_title),
            fontSize = 16.sp,
            color = Color(0xff2b7d4e),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Contact(
            Icons.Rounded.Phone,
            iconDescription = stringResource(R.string.icon_phone),
            stringResource(R.string.phone),
        )
        Contact(
            Icons.Rounded.Email,
            iconDescription = stringResource(R.string.icon_email),
            text = stringResource(R.string.email),
        )
        Contact(
            Icons.Rounded.Share,
            iconDescription = stringResource(R.string.icon_share),
            text = stringResource(R.string.social_handle),
        )
    }
}

@Composable
fun Contact(iconVector: ImageVector, iconDescription: String, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(iconVector, contentDescription = iconDescription, tint = Color(0xff2b7d4e))
        Text(text = text, textAlign = TextAlign.Start, fontSize = 12.sp)
//        Text(text = buildAnnotatedString {
//            appendInlineContent("icon", "icon")
//            append(text)
//        },
//            inlineContent = mapOf(
//                Pair("icon", InlineTextContent(
//                    Placeholder(
//                        width = 1.7.em,
//                        height = 23.sp,
//                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextTop
//                    )
//                ) {
//                    Icon(
//                        iconVector,
//                        contentDescription = iconDescription,
//                        tint = Color(0xff2b7d4e)
//                    )
//                }
//                )),
//            lineHeight = 23.sp,
//            color = Color.Black,
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Normal)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}