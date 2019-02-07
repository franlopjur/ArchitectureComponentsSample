package com.betabeers.architecturecomponentsexample.data

import com.betabeers.architecturecomponentsexample.api.request.searchRepositories
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain
import com.betabeers.architecturecomponentsexample.model.dto.GithubRepoSearchDto
import com.betabeers.architecturecomponentsexample.model.mapper.dtoListToDomainList
import com.betabeers.architecturecomponentsexample.commons.notNull
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepository {
    //region Public Methods
    fun searchRepos(query: String, executeIfOk: (List<GithubRepoDomain>) -> Unit, executeIfKo: (String) -> Unit) {
        searchRepositories(query).enqueue(object :
            Callback<GithubRepoSearchDto> {
            override fun onResponse(call: Call<GithubRepoSearchDto>, response: Response<GithubRepoSearchDto>) {
                if (response.isSuccessful) {
                    response.body().notNull {
                        executeIfOk(dtoListToDomainList(response.body()?.items))
                    }

                } else {
                    executeIfKo("Error")
                }
            }

            override fun onFailure(call: Call<GithubRepoSearchDto>, t: Throwable) {
                executeIfKo("Error al realizar la llamada")
            }
        })
    }
    //endregion
}