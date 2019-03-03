package com.betabeers.architecturecomponentsexample.api

import com.betabeers.architecturecomponentsexample.commons.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        @Volatile
        private var sRetrofitInstance: Retrofit? = null

        @Volatile
        private var sClient: OkHttpClient? = null

        fun getInstance() : Retrofit =
            sRetrofitInstance ?: synchronized(this) {
                sRetrofitInstance ?: Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getClientInstance())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

        private fun getClientInstance() : OkHttpClient =
                sClient ?: synchronized(this) {
                    sClient ?: OkHttpClient.Builder()
                        .addInterceptor(getLogger())
                        .build()
                }

        private fun getLogger() : HttpLoggingInterceptor {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC
            return logger
        }
    }
}