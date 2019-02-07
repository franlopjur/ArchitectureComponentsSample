package com.betabeers.architecturecomponentsexample.model.mapper

import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoSearchDomain
import com.betabeers.architecturecomponentsexample.model.dto.GithubRepoSearchDto

fun dtoToDomain(dto: GithubRepoSearchDto): GithubRepoSearchDomain {
    val domain = GithubRepoSearchDomain()
    domain.items = dtoListToDomainList(dto.items)
    domain.nextPage = dto.nextPage
    domain.totalCount = dto.totalCount
    return domain
}