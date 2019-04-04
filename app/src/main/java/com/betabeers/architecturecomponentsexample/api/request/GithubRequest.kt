package com.betabeers.architecturecomponentsexample.api.request

import com.betabeers.architecturecomponentsexample.api.createGithubService
import com.betabeers.architecturecomponentsexample.model.dto.GithubRepoSearchDto
import retrofit2.Call

fun searchRepositories(query: String, page: Int, itemPerPage: Int): Call<GithubRepoSearchDto> {
    return createGithubService().searchRepositories(query, page, itemPerPage)
}