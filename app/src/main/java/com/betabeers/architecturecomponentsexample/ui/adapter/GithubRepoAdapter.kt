package com.betabeers.architecturecomponentsexample.ui.adapter

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.betabeers.architecturecomponentsexample.R
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

class GithubRepoAdapter(var onItemClick: (position: Int, repoDomain: GithubRepoDomain) -> Unit)
    : PagedListAdapter<GithubRepoDomain, GithubRepoAdapter.GithubRepoViewHolder>(REPO_COMPARATOR) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GithubRepoAdapter.GithubRepoViewHolder {
        return GithubRepoViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.row_github_repo, viewGroup, false)
        )
    }

    override fun onBindViewHolder(viewHolder: GithubRepoAdapter.GithubRepoViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            viewHolder.bind(item, position)
        }
    }

    fun getItemByPosition(position: Int): GithubRepoDomain? {
        return getItem(position)
    }

    inner class GithubRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameLabel: TextView = itemView.findViewById(R.id.row_github_repo__label__name)

        fun bind(repo: GithubRepoDomain?, position: Int) {
            if (repo != null) {
                val name =
                    String.format(itemView.context.getString(R.string.row_info_format), position, repo.name)
                nameLabel.text = name
                itemView.setOnClickListener { onItemClick(adapterPosition, repo) }
            }
        }
    }

    companion object {
        private val REPO_COMPARATOR =
            object : DiffUtil.ItemCallback<GithubRepoDomain>() {
                override
                fun areItemsTheSame(oldItem: GithubRepoDomain,
                                             newItem: GithubRepoDomain): Boolean =
                    oldItem.fullName == newItem.fullName

                override
                fun areContentsTheSame(oldItem: GithubRepoDomain,
                                       newItem: GithubRepoDomain): Boolean =
                    oldItem == newItem
        }
    }


}