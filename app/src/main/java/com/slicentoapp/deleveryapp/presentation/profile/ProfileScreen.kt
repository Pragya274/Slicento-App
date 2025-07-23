package com.slicentoapp.deleveryapp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ExitToApp
import androidx.compose.material.icons.automirrored.rounded.Help
import androidx.compose.material.icons.automirrored.rounded.NavigateNext
import androidx.compose.material.icons.automirrored.rounded.Notes
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Feedback
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Policy
import androidx.compose.material.icons.rounded.StarRate
import androidx.compose.material.icons.rounded.SupportAgent
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.slicentoapp.deleveryapp.R
import com.slicentoapp.deleveryapp.ui.theme.Orange40
import com.slicentoapp.deleveryapp.ui.theme.SkyBlue40


@Composable
fun ProfileScreen(appNavigation: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        ProfileSection()

        Box(modifier = Modifier.height(50.dp))

        ProfileDetails()

        Box(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            color = Color.LightGray
        )
        Box(modifier = Modifier.height(8.dp))
        ProfileOptions()
        Box(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            color = Color.LightGray
        )
        Box(modifier = Modifier.height(8.dp))
        MoreSettingsOptions()

    }

}


@Composable
@Preview(showBackground = true)
fun MoreSettingsOptions() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "More Settings",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.Rounded.Policy,
            text = "Policy"
        )

        Options(
            icon = Icons.AutoMirrored.Rounded.Notes,
            text = "Terms & Conditions"
        )
        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.AutoMirrored.Rounded.Help,
            text = "Help"
        )
        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.Rounded.StarRate,
            text = "Rate Us"
        )
        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.Rounded.Feedback,
            text = "Feedback"
        )
        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.Rounded.SupportAgent,
            text = "Contact Support"
        )


    }
}

@Composable
fun ProfileOptions() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Profile Options",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.Rounded.LocationOn,
            text = "Address"
        )

        Options(
            icon = Icons.Rounded.Edit,
            text = "Edit Profile"
        )
        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.Rounded.Password,
            text = "Change Password"
        )
        Box(modifier = Modifier.height(8.dp))
        Options(
            icon = Icons.AutoMirrored.Rounded.ExitToApp,
            text = "Log Out"
        )
    }
}

@Composable
fun ProfileDetails() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // name
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
        // spacer
        Box(modifier = Modifier.padding(1.dp))
        // email
        Text(
            text = "jdoe@me.com",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray
        )

        Box(modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🛒12",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                // spacer
                Box(modifier = Modifier.height(4.dp))
                Text(
                    text = "Orders",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }

            Box(modifier = Modifier.padding(4.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "💵150.8",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                // spacer
                Box(modifier = Modifier.height(4.dp))
                Text(
                    text = "Saved",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }

            Box(modifier = Modifier.padding(4.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "⭐4.5",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                // spacer
                Box(modifier = Modifier.height(4.dp))
                Text(
                    text = "Rating",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
            }

        }

    }
}

@Composable
fun ProfileSection() {
    Box(modifier = Modifier.fillMaxWidth())
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#F28C28")),
                            Color(android.graphics.Color.parseColor("#A87C6F"))
                        )
                    )
                )
                .align(Alignment.Center),

            )

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .offset(y = 50.dp)
                .size(100.dp)
                .clip(CircleShape)
                .shadow(
                    elevation = 4.dp,
                    shape = CircleShape
                )
                .align(Alignment.Center),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
    }


}


@Composable
fun Options(
    icon: ImageVector,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clip(
                RoundedCornerShape(16.dp)
            )
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    containerColor = Color.Black.copy(0.1f)
                )
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.Black

                )

            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black.copy(0.6f)
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.NavigateNext,
                contentDescription = null,
                tint = Color.Black

            )

        }
    }


}