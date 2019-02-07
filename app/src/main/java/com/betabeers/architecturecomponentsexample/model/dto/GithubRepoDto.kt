package com.betabeers.architecturecomponentsexample.model.dto

import com.betabeers.architecturecomponentsexample.commons.*
import com.google.gson.annotations.SerializedName

data class GithubRepoDto (
    @SerializedName(DTO__GITHUB_REPO__ID)
    val id: Long = 0,
    @SerializedName(DTO__GITHUB_REPO__NAME)
    val name: String? = null,
    @SerializedName(DTO__GITHUB_REPO__FULL_NAME)
    val fullName: String? = null,
    @SerializedName(DTO__GITHUB_REPO__DESCRIPTION)
    val description: String? = null,
    @SerializedName(DTO__GITHUB_REPO__HTML_URL)
    val url: String? = null,
    @SerializedName(DTO__GITHUB_REPO__STARGAZERS_COUNT)
    val stars: Int = 0,
    @SerializedName(DTO__GITHUB_REPO__FORKS_COUNT)
    val forks: Int = 0,
    @SerializedName(DTO__GITHUB_REPO__LANGUAGE)
    val language: String? = null
)