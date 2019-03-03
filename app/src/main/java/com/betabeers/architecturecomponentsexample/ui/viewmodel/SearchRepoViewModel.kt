package com.betabeers.architecturecomponentsexample.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.betabeers.architecturecomponentsexample.data.GithubRepository
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

class SearchRepoViewModel : ViewModel() {

    //region Members
    private val queryLiveData = MutableLiveData<String>()
    private val githubRepository: GithubRepository = GithubRepository()

    var errorMessageLiveData: LiveData<String>

    val githubReposListLiveData: LiveData<List<GithubRepoDomain>> =
        Transformations.switchMap(queryLiveData) { query -> search(query) }

    //endregion

    init {
        errorMessageLiveData = githubRepository.errorLiveData
    }

    //region Public Methods
    fun updateQuery(newQuery: String) {
        queryLiveData.postValue(newQuery)
    }
    //endregion

    //region Private Methods
    private fun search(query: String): LiveData<List<GithubRepoDomain>> {
        return githubRepository.searchRepos(query)
    }
    //endregion
}