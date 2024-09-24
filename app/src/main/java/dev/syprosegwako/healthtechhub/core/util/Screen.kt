package dev.syprosegwako.healthtechhub.core.util

sealed class Screen(val route: String){
    data object HomeScreen: Screen("home")
    data object BlogListScreen: Screen("blog_list")
    data object BlogAddScreen: Screen("add_blog")
    data object BlogDetailScreen: Screen("blog_detail")
}