package dev.syprosegwako.healthtechhub.blog.presentation.blog_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.syprosegwako.healthtechhub.ui.theme.HealthTechHubTheme
import dev.syprosegwako.healthtechhub.blog.domain.BlogItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogListScreen(
    navController: NavController,
    viewModel: BlogListViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    LaunchedEffect(key1 = true) {
        viewModel.getBlogs()
    }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add blog",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                
            }
        },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "Blog Posts",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "menu"
                        )
                    }
                },
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
            )
        }
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 40.dp)
            ) {

                items(state.blogs){ blog ->
                    BlogListItem(
                        blog = blog,
                        onBlogClick = {id -> viewModel.onFilterTopics(id) }
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

@Composable
fun BlogListItem(
    blog: BlogItem,
    onBlogClick: (Int) -> Unit,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = blog.subject,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = blog.createdAt,
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Next Icon",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = modifier.size(20.dp)
            )

        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 0.2.dp,
            color = Color.Black
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BlogItemPreview(){
    HealthTechHubTheme {
        BlogListItem(
            blog = BlogItem(
                id = 1,
                name = "Syprose",
                surname = "Gwako",
                subject = "This is my subject",
                body = "This is my body",
                topicId = 1,
                createdAt = "19/09/2024",
                updatedAt = "19/09/2024"
            ),
            onBlogClick = {}
        )
    }

}