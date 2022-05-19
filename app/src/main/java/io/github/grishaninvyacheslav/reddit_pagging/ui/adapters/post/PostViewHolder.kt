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
        binding.title.text = title
    }

    override fun setRating(rating: String) {
        binding.rating.text = rating
    }

    override fun setCommentCount(commentCount: String) {
        binding.commentCount.text = commentCount
    }
}