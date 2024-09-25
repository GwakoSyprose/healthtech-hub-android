package dev.syprosegwako.healthtechhub.blog.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.syprosegwako.healthtechhub.R
import dev.syprosegwako.healthtechhub.core.components.AppLayout
import dev.syprosegwako.healthtechhub.core.util.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {
    AppLayout(
        navController = navController,
        title = "Home Screen",
        showNav = false,
        showFab = false,
        onFabClick = {},
    ) { modifier ->
        Column (
            modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 40.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ){
            Image(
                painter = painterResource(R.drawable.logo) ,
                contentDescription = "logo",
                alignment = Alignment.TopStart,
                modifier = Modifier.padding(vertical = 16.dp).height(80.dp).width(200.dp),
                contentScale = ContentScale.Fit
                )
            Text(
                text = "HealthTech Hub Blog",
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_16))
            )
            Text(
                text = "Discover the latest in digital health and medical advancements. Explore our blog to read informative articles,or add your own content to share your insights with the community.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_24))
            )
            Button(
                onClick = { navController.navigate(Screen.BlogListScreen.route)}) {
                Row {
                    Text(text = "Check out our blogs")
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "" )
                }
            }
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 24.dp)
            )
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "Stay updated with the latest news or reach out to our support team for help.",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_16))
            )

        }

    }

}
