package io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos.PostData
import io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post.HotPostsPagingSource
import kotlinx.coroutines.flow.Flow

const val NETWORK_PAGE_SIZE = 27

internal class RedditListingRepository(
    private val postsService: RedditListingService
) : IRedditListingRepository {

    override fun getHot(): Flow<PagingData<PostData>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                HotPostsPagingSource(service = postsService)
            }
        ).flow
    }
}