package io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import io.github.grishaninvyacheslav.reddit_pagging.databinding.ItemPostBinding
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.dtos.PostData

class HotPostsListAdapter(
    private val dataModel: IHotPostsDataModel,
) : PagingDataAdapter<PostData, PostViewHolder>(PostsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holderMarker: PostViewHolder, position: Int) =
        dataModel.bindView(holderMarker, getItem(position))
}