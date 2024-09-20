package dev.syprosegwako.healthtechhub.blog.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.syprosegwako.healthtechhub.blog.presentation.blog_add.BlogAddScreen
import dev.syprosegwako.healthtechhub.blog.presentation.blog_list.BlogListScreen
import dev.syprosegwako.healthtechhub.blog.presentation.blog_list.BlogListViewModel
import dev.syprosegwako.healthtechhub.ui.theme.HealthTechHubTheme
import dev.syprosegwako.healthtechhub.util.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthTechHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val blogListViewModel: BlogListViewModel = hiltViewModel()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.BlogListScreen.route,
                    ) {
                        composable(route = Screen.BlogListScreen.route) {
                            BlogListScreen(
                                navController = navController,
                                viewModel = blogListViewModel
                            )
                        }
                        composable(route = Screen.BlogAddScreen.route) {
                            BlogAddScreen()
                        }

                    }

                }
            }
        }
    }
}

