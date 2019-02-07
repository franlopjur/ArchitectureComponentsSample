package com.betabeers.architecturecomponentsexample.model.domain

data class GithubRepoSearchDomain(
    var totalCount: Int = 0,
    var items: List<GithubRepoDomain> = emptyList(),
    var nextPage: Int? = null
)