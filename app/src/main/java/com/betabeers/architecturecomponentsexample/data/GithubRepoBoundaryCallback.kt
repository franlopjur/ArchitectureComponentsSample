package com.betabeers.architecturecomponentsexample.data

import android.arch.paging.PagedList
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

class GithubRepoBoundaryCallback(private val query: String,
                                 private val repoApiDataSource: GithubRepoApiDataSource,
                                 private val repoCacheDataSource: GithubRepoLocalDataSource) : PagedList.BoundaryCallback<GithubRepoDomain>() {

    private var isRequesting: Boolean = false
    var lastPageRequestedNumber = 1

    fun resetLastPageRequestedNumber() {
        this.lastPageRequestedNumber = 1
    }

    fun increaseLastPageRequestedNumber() {
        this.lastPageRequestedNumber++
    }

    private fun requestNewDataAndSave(query: String) {
        isRequesting = true
        repoApiDataSource.getGithubRepos(query,
            lastPageRequestedNumber,
            {
                isRequesting = false
                increaseLastPageRequestedNumber()
                repoCacheDataSource.insert(it)
            }, {
                isRequesting = false
            })
    }


    override fun onZeroItemsLoaded() {
        requestNewDataAndSave(query)
    }

    override fun onItemAtEndLoaded(itemAtEnd: GithubRepoDomain) {
        requestNewDataAndSave(query)
    }
}