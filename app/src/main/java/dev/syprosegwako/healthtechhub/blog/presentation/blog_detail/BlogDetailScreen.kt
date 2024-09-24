package dev.syprosegwako.healthtechhub.blog.presentation.blog_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.syprosegwako.healthtechhub.R
import dev.syprosegwako.healthtechhub.blog.presentation.AppLayout
import dev.syprosegwako.healthtechhub.util.formatDate

@Composable
fun BlogDetailScreen(
    navController: NavController,
    viewModel: BlogDetailViewModel = hiltViewModel()
) {
    val selectedBlog = viewModel.state.value.blog
    AppLayout(
        navController = navController,
        title = "Back to Posts",
        showFab = false,
        onFabClick = {},
    ) { modifier ->
        Column (
            modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState())
        ){
            Text(
                text = selectedBlog.subject,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_8))
            )
            Text(
                text = "${selectedBlog.createdAt.formatDate()} | ${selectedBlog.name} ${selectedBlog.surname}",
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_16))
            )
            Text(
                text = selectedBlog.body,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_16))
            )

        }

    }

}
