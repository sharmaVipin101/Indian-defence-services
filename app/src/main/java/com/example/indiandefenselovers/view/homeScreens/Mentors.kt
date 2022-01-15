package com.example.indiandefenselovers.view.homeScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.BaseFiles.BaseCustomView
import com.example.indiandefenselovers.repository.network.ENDPOINTS
import com.example.indiandefenselovers.repository.network.RetroCall
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.view.adapters.MentorsAdapter
import com.example.indiandefenselovers.databinding.FragmentMentorsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class Mentors : Fragment() {

    private lateinit var binding: FragmentMentorsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MentorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMentorsBinding.inflate(inflater, container, false)
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE
        init()
        return binding.root
    }

    private fun init() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvMentorsList
        adapter = MentorsAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity?.baseContext)

        CoroutineScope(Dispatchers.IO).launch {
            getMentorsData()
        }

    }

    private suspend fun getMentorsData() {

        val service: ENDPOINTS? =  RetroCall.getRetroInstance()?.create(ENDPOINTS::class.java)

        val call = service?.getMentors()!!
        call.enqueue(object : Callback,
            retrofit2.Callback<List<BaseCustomView>> {

            override fun onResponse(
                call: Call<List<BaseCustomView>>,
                response: Response<List<BaseCustomView>>,
            ) {
                adapter.update(response.body()!!)
            }

            override fun onFailure(call: Call<List<BaseCustomView>>, t: Throwable) {
                Toast.makeText(context, "Fail", Toast.LENGTH_LONG)
            }

        })
    }

}