package io.github.grishaninvyacheslav.reddit_pagging.domain.models.repository

import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.PostData
import io.github.grishaninvyacheslav.reddit_pagging.domain.models.IRedditListingsDataSource
import java.lang.RuntimeException

class RedditListingService(private val api: IRedditListingsDataSource) {
    private val pagesLastItems = arrayListOf("null")

    suspend fun getHotPosts(
        page: Int
    ): List<PostData> {
        if (page < 1) {
            throw RuntimeException()
        }
        val afterAnchor =
            pagesLastItems.getOrNull(page - 1)
                ?: run {
                    fetchAnchorsForPages(page)
                    pagesLastItems.last()
                }
        return api.hot(afterAnchor).data.children.map { it.data }
    }

    private suspend fun fetchAnchorsForPages(lastPage: Int){
        for (i in pagesLastItems.size until lastPage) {
            api.hot(pagesLastItems[i - 1]).data.after?.let { pagesLastItems.add(it) }
                ?: break
        }
    }
}