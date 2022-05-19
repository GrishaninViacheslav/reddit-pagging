package io.github.grishaninvyacheslav.reddit_pagging.domain.entities.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos.PostData

@Entity
data class RedditListing(
    @PrimaryKey val page: Int,
    @ColumnInfo(name = "posts") val posts: List<PostData>
)