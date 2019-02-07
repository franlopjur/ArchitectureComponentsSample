package com.betabeers.architecturecomponentsexample.api

fun createGithubService(): GithubService {
    return ApiService.getInstance().create(GithubService::class.java)
}
