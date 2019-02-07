package com.betabeers.architecturecomponentsexample.model.domain

data class GithubRepoDomain(
    var id: Long = 0,
    var name: String? = null,
    var fullName: String? = null,
    var description: String? = null,
    var url: String? = null,
    var stars: Int = 0,
    var forks: Int = 0,
    var language: String? = null
)
