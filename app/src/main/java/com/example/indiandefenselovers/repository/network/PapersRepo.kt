package com.example.indiandefenselovers.repository.network

import androidx.lifecycle.MutableLiveData
import com.example.indiandefenselovers.repository.model.Clickable
import com.example.indiandefenselovers.repository.model.Paper
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PapersRepo {

    private var papersList = MutableLiveData<List<Paper?>>()
    fun getPapersData(data: Clickable): MutableLiveData<List<Paper?>> {
        val call = getEndpoint(data)
        call?.enqueue(object : Callback, retrofit2.Callback<List<Paper>> {
            override fun onResponse(call: Call<List<Paper>>, response: Response<List<Paper>>) {
                papersList.value = response.body()
            }

            override fun onFailure(call: Call<List<Paper>>, t: Throwable) {

            }
        })
        return papersList
    }

    private fun getEndpoint(data: Clickable): Call<List<Paper>>? {
        val service: ENDPOINTS? = RetroCall.getRetroInstance()?.create(ENDPOINTS::class.java)
        return when (data.param1) {
            "cds" -> {
                service?.getCdsPapers()
            }
            "nda" -> {
                service?.getNdaPapers()
            }
            else -> null
        }
    }
}