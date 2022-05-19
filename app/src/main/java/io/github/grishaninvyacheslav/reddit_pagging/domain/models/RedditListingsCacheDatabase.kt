package io.github.grishaninvyacheslav.reddit_pagging.domain.models

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.room.Converters
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.room.RedditListing
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.room.RedditListingsCacheDao

@Database(entities = [RedditListing::class], version = 1)
@TypeConverters(Converters::class)
abstract class RedditListingsCacheDatabase : RoomDatabase() {
    abstract fun dao(): RedditListingsCacheDao
}