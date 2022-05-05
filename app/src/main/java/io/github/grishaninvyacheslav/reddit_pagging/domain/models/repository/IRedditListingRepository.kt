package io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository

import androidx.paging.PagingData
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.PostData
import kotlinx.coroutines.flow.Flow

interface IRedditListingRepository {
    fun getHot(): Flow<PagingData<PostData>>
}
