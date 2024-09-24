package dev.syprosegwako.healthtechhub.blog.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import dev.syprosegwako.healthtechhub.blog.presentation.blog_add.BlogAddScreen
import dev.syprosegwako.healthtechhub.blog.presentation.blog_add.BlogNewViewModel
import dev.syprosegwako.healthtechhub.blog.presentation.blog_detail.BlogDetailScreen
import dev.syprosegwako.healthtechhub.blog.presentation.blog_list.BlogListScreen
import dev.syprosegwako.healthtechhub.blog.presentation.blog_list.BlogListViewModel
import dev.syprosegwako.healthtechhub.blog.presentation.home.HomeScreen
import dev.syprosegwako.healthtechhub.ui.theme.HealthTechHubTheme
import dev.syprosegwako.healthtechhub.core.util.Constants.Navigation.ARG_BLOG_ID
import dev.syprosegwako.healthtechhub.core.util.Constants.Navigation.BLOG_ID
import dev.syprosegwako.healthtechhub.core.util.Screen

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
                    val blogNewViewModel: BlogNewViewModel = hiltViewModel()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route,
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.BlogListScreen.route) {
                            BlogListScreen(
                                navController = navController,
                                viewModel = blogListViewModel
                            )
                        }
                        composable(route = Screen.BlogAddScreen.route) {
                            BlogAddScreen(
                                navController = navController,
                                viewModel = blogNewViewModel
                            )
                        }
                        composable(
                            route = Screen.BlogDetailScreen.route + "?$ARG_BLOG_ID={$BLOG_ID}",
                            arguments = listOf(
                                navArgument(
                                    name = BLOG_ID
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ){
                            BlogDetailScreen(
                                navController = navController
                            )
                        }

                    }

                }
            }
        }
    }
}

