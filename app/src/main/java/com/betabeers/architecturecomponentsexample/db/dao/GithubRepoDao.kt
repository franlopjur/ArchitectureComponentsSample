package com.betabeers.architecturecomponentsexample.db.dao

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

@Dao
interface GithubRepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repoList: List<GithubRepoDomain>)

    @Query("SELECT * FROM GithubRepos WHERE (name LIKE :query) OR (description LIKE :query)")
    fun getReposAsync(query: String): DataSource.Factory<Int, GithubRepoDomain>

    @Query("SELECT * FROM GithubRepos WHERE (name LIKE :query) OR (description LIKE :query)")
    fun getRepos(query: String): List<GithubRepoDomain>

}