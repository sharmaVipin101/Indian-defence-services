package com.example.indiandefenselovers.view.homeScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.BaseFiles.clickableCallback
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.databinding.FragmentHomeBinding
import com.example.indiandefenselovers.repository.model.Clickable
import com.example.indiandefenselovers.view.adapters.homeAdapters.HomeItemsAdapter
import com.example.indiandefenselovers.viewModel.HomeItemsVM
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : Fragment(), clickableCallback {

    lateinit var binding:FragmentHomeBinding
    lateinit var homeItemsRView: RecyclerView
    lateinit var adapter: HomeItemsAdapter
    lateinit var viewModel: HomeItemsVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE

        init()
        return binding.root
    }

    private fun init() {
        setupViewModel()
        setupRecyclerView()
        getData()
    }
    private fun setupViewModel() {
        activity?.let {
            viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(it.application)).get(HomeItemsVM::class.java)
        }
    }

    private fun getData() {
        viewModel.getHomeItems().observe(viewLifecycleOwner, {
            it?.let {
                adapter.updateList(it)
            }
        })
    }

    private fun setupRecyclerView() {
        homeItemsRView = binding.homeItems
        adapter = HomeItemsAdapter(this)
        homeItemsRView.adapter = adapter
        homeItemsRView.layoutManager = LinearLayoutManager(binding.root.context)
    }

    override fun onItemClick(item: Clickable?) {
        item?.let {
            if(it.param1.isNullOrEmpty()){
                return
            }
            val action = HomeDirections.actionHome2ToPreviousPapers(item)
            findNavController().navigate(action)
        }
    }
}