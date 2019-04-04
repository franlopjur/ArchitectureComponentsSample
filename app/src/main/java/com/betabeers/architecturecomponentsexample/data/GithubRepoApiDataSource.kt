package com.betabeers.architecturecomponentsexample.data

import com.betabeers.architecturecomponentsexample.R
import com.betabeers.architecturecomponentsexample.api.request.searchRepositories
import com.betabeers.architecturecomponentsexample.commons.ITEMS_PER_PAGE_NETWORK
import com.betabeers.architecturecomponentsexample.commons.getString
import com.betabeers.architecturecomponentsexample.commons.notNull
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain
import com.betabeers.architecturecomponentsexample.model.dto.GithubRepoSearchDto
import com.betabeers.architecturecomponentsexample.model.mapper.dtoListToDomainList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepoApiDataSource {

    fun getGithubRepos(query: String,
                       page: Int,
                       success: (response: List<GithubRepoDomain>) -> Unit,
                       failure: (errorMessage: String) -> Unit) {

            searchRepositories(query, page, ITEMS_PER_PAGE_NETWORK).enqueue(object : Callback<GithubRepoSearchDto> {
                override fun onResponse(call: Call<GithubRepoSearchDto>,
                                        response: Response<GithubRepoSearchDto>) {
                    if (response.isSuccessful) {
                        response.body().notNull { success(dtoListToDomainList(response.body()?.items)) }

                    } else {
                        failure(getString(R.string.response_error))
                    }
                }

                override fun onFailure(call: Call<GithubRepoSearchDto>, t: Throwable) {
                    failure(getString(R.string.service_error))
                }
            })
    }

}