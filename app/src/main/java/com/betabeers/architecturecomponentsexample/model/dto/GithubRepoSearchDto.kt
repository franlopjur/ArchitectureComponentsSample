package com.betabeers.architecturecomponentsexample.model.dto

import com.betabeers.architecturecomponentsexample.commons.DTO__GITHUB_REPO_SEARCH__ITEMS
import com.betabeers.architecturecomponentsexample.commons.DTO__GITHUB_REPO_SEARCH__TOTAL_COUNT
import com.google.gson.annotations.SerializedName

data class GithubRepoSearchDto(
    @SerializedName(DTO__GITHUB_REPO_SEARCH__TOTAL_COUNT)
    val totalCount: Int = 0,
    @SerializedName(DTO__GITHUB_REPO_SEARCH__ITEMS)
    val items: List<GithubRepoDto> = emptyList(),
    val nextPage: Int? = null
)