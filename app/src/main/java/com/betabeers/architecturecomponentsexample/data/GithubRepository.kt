package com.betabeers.architecturecomponentsexample.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.text.TextUtils
import com.betabeers.architecturecomponentsexample.commons.ITEMS_PER_PAGE_DB
import com.betabeers.architecturecomponentsexample.commons.ITEMS_PER_PAGE_NETWORK
import com.betabeers.architecturecomponentsexample.commons.PREFETCH_DISTANCE
import com.betabeers.architecturecomponentsexample.commons.notNull
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

class GithubRepository {

    private var repoApiDataSource: GithubRepoApiDataSource = GithubRepoApiDataSource()
    private var repoLocalCacheDataSource: GithubRepoLocalDataSource = GithubRepoLocalDataSource()
    var errorLiveData: MutableLiveData<String> = MutableLiveData()

    private var callback: GithubRepoBoundaryCallback? = null
    private var lastQueryInfoRequested: String? = null

    //region Public Methods

    fun searchRepos(query: String) : LiveData<PagedList<GithubRepoDomain>> {
        if (!isSameQueryThanLastQuery(query) ||
            callback == null) {
            callback = GithubRepoBoundaryCallback(query,
                repoApiDataSource,
                repoLocalCacheDataSource)
            lastQueryInfoRequested = query
            setUpLastPageNumberToQuery(query)
        }
        val factory = repoLocalCacheDataSource.getGithubRepos(query)
        val config : PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(ITEMS_PER_PAGE_DB)
            .setPageSize(ITEMS_PER_PAGE_DB)
            .setPrefetchDistance(PREFETCH_DISTANCE).build()
        val livePagedBuilder = LivePagedListBuilder(factory, config)
        livePagedBuilder.setBoundaryCallback(callback)

        return livePagedBuilder.build()
    }

    //endregion

    private fun isSameQueryThanLastQuery(query: String): Boolean {
        return !TextUtils.isEmpty(lastQueryInfoRequested) &&
                lastQueryInfoRequested.equals(query, ignoreCase = true)
    }

    private fun setUpLastPageNumberToQuery(query: String) {
        repoLocalCacheDataSource.getGithubReposWithoutLiveData(query) {
            if (!it.isEmpty()) {
                callback?.lastPageRequestedNumber = (it.size / ITEMS_PER_PAGE_NETWORK + 1)
            }
        }
    }

}