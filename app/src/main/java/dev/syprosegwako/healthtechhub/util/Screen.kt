package dev.syprosegwako.healthtechhub.util

sealed class Screen(val route: String){
    data object BlogListScreen: Screen("blog_list")
    data object BlogAddScreen: Screen("add_blog")
    data object BlogDetailScreen: Screen("blog_detail")
}