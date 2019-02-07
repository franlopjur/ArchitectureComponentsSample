package com.betabeers.architecturecomponentsexample.ui.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.betabeers.architecturecomponentsexample.data.GithubRepository
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

class SearchRepoViewModel : ViewModel() {

    //region Members
    private val githubRepository: GithubRepository = GithubRepository()
    val errorMessageLiveData = MutableLiveData<String>()
    val searchReposLiveData = MutableLiveData<List<GithubRepoDomain>>()
    //endregion

    //region Public Methods
    fun search(query: String) {
        return githubRepository.searchRepos(query,
            {
                searchReposLiveData.postValue(it)
            },
            {
                errorMessageLiveData.postValue(it)
            }
        )
    }
    //endregion
}