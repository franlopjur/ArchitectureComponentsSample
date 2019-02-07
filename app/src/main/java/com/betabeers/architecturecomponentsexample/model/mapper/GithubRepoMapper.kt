package com.betabeers.architecturecomponentsexample.model.mapper

import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain
import com.betabeers.architecturecomponentsexample.model.dto.GithubRepoDto
import java.util.ArrayList

//region Public Methods
fun dtoListToDomainList(dtoList: List<GithubRepoDto>?): List<GithubRepoDomain> {
    val domainList = ArrayList<GithubRepoDomain>()
    if (dtoList != null && !dtoList.isEmpty()) {
        for (dto in dtoList) {
            domainList.add(dtoToDomain(dto))
        }
    }
    return domainList
}
//endregion

//region Private Methods
private fun dtoToDomain(dto: GithubRepoDto?): GithubRepoDomain {
    val domain = GithubRepoDomain()
    if (dto != null) {
        domain.description = dto.description
        domain.forks = dto.forks
        domain.fullName = dto.fullName
        domain.id = dto.id
        domain.language = dto.language
        domain.name = dto.name
        domain.stars = dto.stars
        domain.url = dto.url
    }
    return domain
}
//endregion