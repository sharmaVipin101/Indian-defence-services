package com.example.indiandefenselovers.repository.network

import com.example.indiandefenselovers.BaseFiles.BaseCustomView
import com.example.indiandefenselovers.repository.model.Clickable
import com.example.indiandefenselovers.repository.model.Paper
import retrofit2.Call
import retrofit2.http.GET

interface ENDPOINTS {

    @GET("mentors.json")
    fun getMentors(): Call<List<BaseCustomView>>

    @GET("cdsPaper.json")
    fun getCdsPapers(): Call<List<Paper>>

    @GET("ndaPaper.json")
    fun getNdaPapers(): Call<List<Paper>>

    @GET("homeItems.json")
    fun getHomeItems(): Call<List<Clickable>>
}