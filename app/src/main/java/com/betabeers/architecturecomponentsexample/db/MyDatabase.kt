package com.betabeers.architecturecomponentsexample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.betabeers.architecturecomponentsexample.commons.CustomApplication
import com.betabeers.architecturecomponentsexample.commons.DB_NAME
import com.betabeers.architecturecomponentsexample.db.dao.GithubRepoDao
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain

@Database(entities = arrayOf(GithubRepoDomain::class), exportSchema = false, version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun reposDao(): GithubRepoDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(): MyDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(CustomApplication.instance).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context,
                MyDatabase::class.java, DB_NAME)
                .build()
    }
}