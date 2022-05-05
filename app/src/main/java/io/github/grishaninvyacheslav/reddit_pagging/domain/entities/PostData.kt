package io.github.grishaninvyacheslav.reddit_pagging.domain.entities

data class PostData(
    val title: String,
    val rating: Int,
    val commentCount: Int
)