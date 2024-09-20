package dev.syprosegwako.healthtechhub.data.mapper

import dev.syprosegwako.healthtechhub.data.local.dto.LocalBlogItem
import dev.syprosegwako.healthtechhub.blog.domain.BlogItem
import dev.syprosegwako.healthtechhub.data.remote.dto.RemoteBlogItem


fun BlogItem.toLocalBlogItem(): LocalBlogItem {
    return LocalBlogItem(
        id = id,
        name = name,
        surname = surname,
        subject = subject,
        topicId = topicId,
        body = body,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun BlogItem.toRemoteBlogItem(): RemoteBlogItem {
    return RemoteBlogItem(
        id = id,
        name = name,
        surname = surname,
        subject = subject,
        topicId = topicId,
        body = body,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun RemoteBlogItem.toLocalBlogItem(): LocalBlogItem {
    return LocalBlogItem(
        id = id,
        name = name,
        surname = surname,
        subject = subject,
        topicId = topicId,
        body = body,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun LocalBlogItem.toRemoteBlogItem(): RemoteBlogItem {
    return RemoteBlogItem(
        id = id,
        name = name,
        surname = surname,
        subject = subject,
        topicId = topicId,
        body = body,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun LocalBlogItem.toBlogItem(): BlogItem {
    return BlogItem(
        id = id,
        name = name,
        surname = surname,
        subject = subject,
        topicId = topicId,
        body = body,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}


fun List<LocalBlogItem>.toBlogItemListFromLocal(): List<BlogItem> {
    return this.map { blog ->
        BlogItem(
            id = blog.id,
            name = blog.name,
            surname = blog.surname,
            subject = blog.subject,
            topicId = blog.topicId,
            body = blog.body,
            createdAt = blog.createdAt,
            updatedAt = blog.updatedAt
        )
    }
}

fun List<LocalBlogItem>.toRemoteBlogItemListFromLocal(): List<RemoteBlogItem> {
    return this.map { blog ->
        RemoteBlogItem(
            id = blog.id,
            name = blog.name,
            surname = blog.surname,
            subject = blog.subject,
            topicId = blog.topicId,
            body = blog.body,
            createdAt = blog.createdAt,
            updatedAt = blog.updatedAt
        )
    }
}

fun List<RemoteBlogItem>.toBlogItemListFromRemote(): List<BlogItem> {
    return this.map { blog ->
        BlogItem(
            id = blog.id,
            name = blog.name,
            surname = blog.surname,
            subject = blog.subject,
            topicId = blog.topicId,
            body = blog.body,
            createdAt = blog.createdAt,
            updatedAt = blog.updatedAt
        )
    }
}

fun List<RemoteBlogItem>.toLocalBlogItemListFromRemote(): List<LocalBlogItem> {
    return this.map { blog ->
        LocalBlogItem(
            id = blog.id,
            name = blog.name,
            surname = blog.surname,
            subject = blog.subject,
            topicId = blog.topicId,
            body = blog.body,
            createdAt = blog.createdAt,
            updatedAt = blog.updatedAt
        )
    }
}
