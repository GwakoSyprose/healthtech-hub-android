package dev.syprosegwako.healthtechhub.blog.presentation.blog_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.syprosegwako.healthtechhub.blog.domain.BlogItem
import dev.syprosegwako.healthtechhub.ui.theme.HealthTechHubTheme
import dev.syprosegwako.healthtechhub.util.formatDate

@Composable
fun BlogListItem(
    blog: BlogItem,
    onBlogClick: (Int?) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = blog.subject,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = blog.createdAt.formatDate(),
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
            IconButton(
                onClick =  { onBlogClick(blog.id) }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next Icon",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = modifier.size(20.dp)
                )
            }

        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 2.dp),
            thickness = 0.2.dp,
            color = Color.Black
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BlogItemPreview() {
    HealthTechHubTheme {
        BlogListItem(
            blog = BlogItem(
                id = 1,
                name = "Syprose",
                surname = "Gwako",
                subject = "This is my subject",
                body = "This is my body",
                topicId = 1,
                createdAt = "2024-09-18T10:20:59.000000Z",
                updatedAt = "2024-09-18T10:20:59.000000Z"
            ),
            onBlogClick = {}
        )
    }

}