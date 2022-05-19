package io.github.grishaninvyacheslav.reddit_pagging.ui.view_models.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos.PostData
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.room.RedditListingsCacheDao
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.IRedditListingsDataSource
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository.IRedditListingRepository
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository.RedditListingRepository
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository.RedditListingService
import kotlinx.coroutines.flow.Flow

class MainViewModel(
    private val api: IRedditListingsDataSource,
    private val cache: RedditListingsCacheDao
) : ViewModel() {
    private val postsRepository: IRedditListingRepository =
        RedditListingRepository(RedditListingService(api, cache))

    fun getHotPosts(): Flow<PagingData<PostData>> {
        return postsRepository.getHot().cachedIn(viewModelScope)
    }
}