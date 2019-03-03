package com.betabeers.architecturecomponentsexample.dp.dao

import android.arch.lifecycle.LiveData
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
    fun getReposAsync(query: String): LiveData<List<GithubRepoDomain>>
}