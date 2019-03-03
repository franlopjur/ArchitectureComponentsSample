package com.betabeers.architecturecomponentsexample.model.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.betabeers.architecturecomponentsexample.commons.DB__GITHUB_REPO__FULL_NAME
import com.betabeers.architecturecomponentsexample.commons.DB__GITHUB_REPO__TABLE_NAME

@Entity(tableName = DB__GITHUB_REPO__TABLE_NAME)
data class GithubRepoDomain(
    @PrimaryKey var id: Long = 0,
    var name: String? = null,
    @ColumnInfo(name = DB__GITHUB_REPO__FULL_NAME) var fullName: String? = null,
    var description: String? = null,
    var url: String? = null,
    var stars: Int = 0,
    var forks: Int = 0,
    var language: String? = null
)
