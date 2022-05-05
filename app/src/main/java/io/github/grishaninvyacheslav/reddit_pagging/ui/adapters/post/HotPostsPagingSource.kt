package io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.PostData
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository.NETWORK_PAGE_SIZE
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository.RedditListingService
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class HotPostsPagingSource(
    private val service: RedditListingService
) : PagingSource<Int, PostData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostData> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getHotPosts(
                page = pageIndex
            )
            val prevKey = if (pageIndex > 1) pageIndex - 1 else null
            val nextKey = if (response.isNotEmpty()) pageIndex + 1 else null
            LoadResult.Page(
                data = response,
                prevKey = prevKey,
                nextKey = nextKey,
                itemsBefore = (pageIndex - 1) * NETWORK_PAGE_SIZE
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PostData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}