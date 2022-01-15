package com.example.indiandefenselovers.view.homeScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.indiandefenselovers.R
import com.example.indiandefenselovers.databinding.FragmentDonateBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Donate : Fragment() {

    lateinit var binding: FragmentDonateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDonateBinding.inflate(inflater, container, false)
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)?.visibility = View.VISIBLE
        return binding.root
    }
}