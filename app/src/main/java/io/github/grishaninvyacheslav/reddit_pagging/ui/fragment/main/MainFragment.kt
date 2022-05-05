package io.github.grishaninvyacheslav.reddit_pagging.ui.fragment.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.grishaninvyacheslav.reddit_pagging.R
import io.github.grishaninvyacheslav.reddit_pagging.databinding.FragmentMainBinding
import io.github.grishaninvyacheslav.reddit_pagging.domain.entities.PostData
import io.github.grishaninvyacheslav.reddit_pagging.ui.BaseFragment
import io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post.HotPostsListAdapter
import io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post.IHotPostsDataModel
import io.github.grishaninvyacheslav.reddit_pagging.ui.adapters.post.IPostItemView
import io.github.grishaninvyacheslav.reddit_pagging.ui.view_models.main.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        collectUiState()
    }

    private fun initList() = with(binding) {
        hotPostsList.layoutManager = LinearLayoutManager(requireContext())
        adapter = HotPostsListAdapter(
            hotPostsDataModel
        )
        hotPostsList.adapter = adapter
    }

    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getHotPosts().collectLatest { posts ->
                adapter?.submitData(posts)
            }
        }
    }

    private val hotPostsDataModel = object : IHotPostsDataModel {
        override fun bindView(view: IPostItemView, data: PostData?) {
            data?.let {
                view.setTitle(it.title)
                view.setRating(it.upVoted.toString())
                view.setCommentCount(it.commentsCount.toString())
            } ?: run {
                view.setTitle(getString(R.string.loading))
                view.setRating(getString(R.string.undefined))
                view.setCommentCount(getString(R.string.undefined))
            }
        }
    }

    private val viewModel: MainViewModel by viewModel()
    private var adapter: HotPostsListAdapter? = null
}