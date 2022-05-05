package io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post

import androidx.recyclerview.widget.RecyclerView
import io.github.grishaninvyacheslav.reddit_pagging.databinding.ItemPostBinding

class PostViewHolder(
    private val binding: ItemPostBinding,
) :
    RecyclerView.ViewHolder(binding.root),
    IPostItemView {
    override val pos: Int = -1

    override fun setTitle(title: String) {
        // TODO("Not yet implemented")
    }

    override fun setRating(rating: String) {
        // TODO("Not yet implemented")
    }

    override fun setCommentCount(commentCount: String) {
        // TODO("Not yet implemented")
    }
}