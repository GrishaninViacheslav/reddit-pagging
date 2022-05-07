package io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos

data class RedditListingData(
    val after: String?,
    val before: String?,
    val dist: Int,
    val children: List<RedditListingDataItem>
)