package com.example.indiandefenselovers.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.repository.model.QA
import com.example.indiandefenselovers.view.adapters.IPaperClick
import com.example.indiandefenselovers.view.adapters.PaperAdapter
import com.example.indiandefenselovers.viewModel.PreviousYearPaperVM
import com.example.indiandefenselovers.databinding.FragmentPreviousPapersBinding
import com.google.android.material.bottomnavigation.BottomNavigationView




class PreviousPapers : Fragment() {

    private lateinit var binding: FragmentPreviousPapersBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PaperAdapter
    private lateinit var viewModel: PreviousYearPaperVM
    private lateinit var args: PreviousPapersArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPreviousPapersBinding.inflate(inflater, container, false)
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.GONE
        getArgs()
       // setupAdView()
        init()
        return binding.root
    }

    private fun getArgs() {
        args = PreviousPapersArgs.fromBundle(requireArguments())
    }

//    private fun setupAdView() {
//        mAdView = binding.adView
//        val adRequest: AdRequest = AdRequest.Builder().build()
//        mAdView?.loadAd(adRequest)
//    }

    private fun init() {
        setupViewModel()
        setupRecyclerView()
        getData()
    }

    private fun setupViewModel() {
        activity?.let {
            viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(it.application)).get(PreviousYearPaperVM::class.java)
        }
    }

    private fun setupRecyclerView() {
        recyclerView = binding.rvCdsPaper
        adapter = PaperAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity?.baseContext)
    }

    private fun getData() {
        viewModel.getPapersList(args.clickable).observe(viewLifecycleOwner, {
            Toast.makeText(context, "UPDATED", Toast.LENGTH_SHORT)
            it?.let {
                adapter.update(it)
            }
        })
    }
}