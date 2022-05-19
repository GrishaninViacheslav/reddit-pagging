package io.github.grishaninvyacheslav.reddit_pagging.domain.entities.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RedditListingsCacheDao {
    @Insert
    suspend fun insert(vararg users: RedditListing)

    @Query("SELECT * FROM RedditListing WHERE page LIKE :cashedPage LIMIT 1")
    suspend fun getByPage(cashedPage: Int): RedditListing?
}