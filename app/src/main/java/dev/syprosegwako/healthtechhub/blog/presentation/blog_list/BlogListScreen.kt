package dev.syprosegwako.healthtechhub.blog.presentation.blog_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.syprosegwako.healthtechhub.core.components.AppLayout
import dev.syprosegwako.healthtechhub.core.components.BlogListItem
import dev.syprosegwako.healthtechhub.core.components.ButtonWithToggleableIcon
import dev.syprosegwako.healthtechhub.core.components.SortButton
import dev.syprosegwako.healthtechhub.core.util.Constants.Navigation.BLOG_ID
import dev.syprosegwako.healthtechhub.core.util.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BlogListScreen(
    navController: NavController,
    viewModel: BlogListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    LaunchedEffect(key1 = true) {
        viewModel.getBlogs()
    }

    AppLayout(
        navController = navController,
        title = "Blog Posts",
        onFabClick = { navController.navigate(Screen.BlogAddScreen.route) }
    ) { modifier ->
        Column(
            modifier
                .fillMaxSize()
                .padding(vertical = 16.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(state.topics) { topic ->
                    val isSelected = state.selectedTopicIds.contains(topic.id)
                    ButtonWithToggleableIcon(
                        isSelected = isSelected,
                        text = topic.title,
                        onSelected = { viewModel.onTopicSelected(topic.id) }
                    )
                }

            }
            // Sort Button Row
            SortButton {
                viewModel.toggleSortOrder()
            }
            LazyColumn {
                items(state.blogs) { blog ->
                    BlogListItem(
                        blog = blog,
                        onBlogClick = { id -> navController.navigate(Screen.BlogDetailScreen.route + "?$BLOG_ID=${id}") }
                    )
                }
            }

            if (state.isLoading) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        Modifier.semantics {
                            this.contentDescription = "loading"
                        }
                    )
                }
            }
            state.error?.let {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = it,
                        fontSize = 24.sp,
                        lineHeight = 36.sp
                    )
                }
            }
        }
    }

}


