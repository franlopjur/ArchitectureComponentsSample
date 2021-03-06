package com.betabeers.architecturecomponentsexample.commons

//region Common
val BASE_URL = "https://api.github.com/"
val DB_NAME = "androidCertificationDatabase"
val ITEMS_PER_PAGE_DB = 20
val ITEMS_PER_PAGE_NETWORK = 50
val PREFETCH_DISTANCE = 5
//endregion

//region DB CONSTANTS
val DB__GITHUB_REPO__TABLE_NAME = "GithubRepos"
val DB__GITHUB_REPO__FULL_NAME = "full_name"
//endregion

//region DTO CONSTANTS
const val DTO__GITHUB_REPO__ID = "id"
const val DTO__GITHUB_REPO__NAME = "name"
const val DTO__GITHUB_REPO__FULL_NAME = "full_name"
const val DTO__GITHUB_REPO__DESCRIPTION = "description"
const val DTO__GITHUB_REPO__HTML_URL = "html_url"
const val DTO__GITHUB_REPO__STARGAZERS_COUNT = "stargazers_count"
const val DTO__GITHUB_REPO__FORKS_COUNT = "forks_count"
const val DTO__GITHUB_REPO__LANGUAGE = "language"
const val DTO__GITHUB_REPO_SEARCH__TOTAL_COUNT = "total_count"
const val DTO__GITHUB_REPO_SEARCH__ITEMS = "items"
//endregion
