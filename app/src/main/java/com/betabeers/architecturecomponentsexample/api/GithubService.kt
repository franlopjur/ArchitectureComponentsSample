package com.betabeers.architecturecomponentsexample.api

import com.betabeers.architecturecomponentsexample.model.dto.GithubRepoSearchDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories?sort=stars")
    fun searchRepositories(@Query("q") query: String): Call<GithubRepoSearchDto>
}