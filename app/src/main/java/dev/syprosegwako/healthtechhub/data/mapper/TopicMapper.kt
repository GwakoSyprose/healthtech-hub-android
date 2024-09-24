package dev.syprosegwako.healthtechhub.data.mapper

import dev.syprosegwako.healthtechhub.blog.domain.TopicItem
import dev.syprosegwako.healthtechhub.data.local.dto.LocalTopicItem
import dev.syprosegwako.healthtechhub.data.remote.dto.RemoteTopicItem

fun List<RemoteTopicItem>.toLocalTopicItemListFromRemote(): List<LocalTopicItem> {
    return this.map { topic ->
        LocalTopicItem(
            id = topic.id,
            title = topic.title,
            createdAt = topic.createdAt,
            updatedAt = topic.updatedAt
        )
    }
}
fun List<LocalTopicItem>.toTopicItemListFromLocal(): List<TopicItem> {
    return this.map { topic ->
        TopicItem(
            id = topic.id,
            title = topic.title
        )
    }
}
