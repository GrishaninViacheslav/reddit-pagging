package io.github.grishaninvyacheslav.reddit_pagging.domain.models

import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos.RedditListing
import retrofit2.http.GET
import retrofit2.http.Query

interface IRedditListingsDataSource {
    @GET("r/aww/hot.json")
    suspend fun hot(@Query("after") after: String): RedditListing
}