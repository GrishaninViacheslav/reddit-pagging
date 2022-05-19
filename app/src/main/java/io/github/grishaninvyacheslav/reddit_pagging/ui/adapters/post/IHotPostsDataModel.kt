package io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post

import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos.PostData

interface IHotPostsDataModel {
    fun bindView(view: IPostItemView, data: PostData?)
}