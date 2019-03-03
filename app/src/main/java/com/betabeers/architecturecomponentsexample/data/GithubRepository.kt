package com.betabeers.architecturecomponentsexample.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

class GithubRepository {

    private var repoApiDataSource: GithubRepoApiDataSource = GithubRepoApiDataSource()
    private var repoLocalCacheDataSource: GithubRepoLocalDataSource = GithubRepoLocalDataSource()
    private var isRequesting: Boolean = false
    var errorLiveData: MutableLiveData<String> = MutableLiveData()

    //region Public Methods
    fun searchRepos(query: String) : LiveData<List<GithubRepoDomain>> {
        if (!isRequesting) {
            isRequesting = true
            repoApiDataSource.getGithubRepos(query, {
                isRequesting = false
                repoLocalCacheDataSource.insert(it)
            }, {
                isRequesting = false
                errorLiveData.postValue(it)
            })
        }
        return repoLocalCacheDataSource.getGithubRepos(query)
    }
    //endregion
}