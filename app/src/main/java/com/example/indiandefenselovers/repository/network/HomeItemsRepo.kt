package com.example.indiandefenselovers.repository.network

import androidx.lifecycle.MutableLiveData
import com.example.indiandefenselovers.repository.model.Clickable
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeItemsRepo {

    private val homeItemsRawList = MutableLiveData<List<Clickable?>>()

    fun getHomeItems(): MutableLiveData<List<Clickable?>> {

        val service: ENDPOINTS? = RetroCall.getRetroInstance()?.create(ENDPOINTS::class.java)
        val call = service?.getHomeItems()
        call?.enqueue(object : Callback, retrofit2.Callback<List<Clickable>> {
            override fun onResponse(
                call: Call<List<Clickable>>,
                response: Response<List<Clickable>>,
            ) {
                homeItemsRawList.value = response.body()
            }

            override fun onFailure(call: Call<List<Clickable>>, t: Throwable) {

            }

        })
        return homeItemsRawList
    }
}