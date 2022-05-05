package io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post

interface IPostItemView {
    val pos: Int
    fun setTitle(title: String)
    fun setRating(rating: String)
    fun setCommentCount(commentCount: String)
}