package io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post

import androidx.recyclerview.widget.DiffUtil
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.PostData

class PostsDiffCallBack : DiffUtil.ItemCallback<PostData>() {
    override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
        return oldItem == newItem
    }
}