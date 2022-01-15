package com.example.indiandefenselovers.repository.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroCall {
    companion object {
        var retrofit: Retrofit? = null
        private const val BASE_URL: String = "https://sharmavipin101.github.io/IndianDefense/"

        fun getRetroInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}