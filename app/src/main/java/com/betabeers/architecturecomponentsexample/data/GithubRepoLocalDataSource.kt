package com.betabeers.architecturecomponentsexample.data

import android.arch.paging.DataSource
import com.betabeers.architecturecomponentsexample.db.MyDatabase
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain
import java.util.concurrent.Executors

class GithubRepoLocalDataSource {

    fun getGithubRepos(query: String): DataSource.Factory<Int, GithubRepoDomain> {
        val likeQuery = transformQueryToLike(query)
        return MyDatabase.getInstance().reposDao().getReposAsync(likeQuery)
    }

    fun getGithubReposWithoutLiveData(query: String, complete: (List<GithubRepoDomain>) -> Unit) {
        val executor = Executors.newSingleThreadExecutor()
        executor.execute {
            complete(MyDatabase.getInstance().reposDao().getRepos(transformQueryToLike(query)))
        }
    }


    //region Insert or Delete Methods

    fun insert(list: List<GithubRepoDomain>) {
        Executors.newSingleThreadExecutor()
            .execute {
                MyDatabase.getInstance().reposDao().insert(list)
            }
    }

    //endregion

    private fun transformQueryToLike(query: String?): String {
        var queryLike = ""
        if (query != null) {
            queryLike = query.replace(" ", "%")
            queryLike = "%$queryLike%"
        }
        return queryLike
    }
}