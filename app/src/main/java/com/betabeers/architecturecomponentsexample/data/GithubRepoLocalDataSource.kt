package com.betabeers.architecturecomponentsexample.data

import android.arch.lifecycle.LiveData
import com.betabeers.architecturecomponentsexample.dp.MyDatabase
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain
import java.util.concurrent.Executors

class GithubRepoLocalDataSource {

    fun getGithubRepos(query: String): LiveData<List<GithubRepoDomain>> {
        val likeQuery = "%${query.replace(' ', '%')}%"
        return MyDatabase.getInstance().reposDao().getReposAsync(likeQuery)
    }

    //region Insert or Delete Methods

    fun insert(list: List<GithubRepoDomain>) {
        Executors.newSingleThreadExecutor()
            .execute {
                MyDatabase.getInstance().reposDao().insert(list)
            }
    }

    //endregion
}