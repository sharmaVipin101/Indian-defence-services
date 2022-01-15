package com.example.indiandefenselovers.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.indiandefenselovers.repository.model.Clickable
import com.example.indiandefenselovers.repository.network.HomeItemsRepo

class HomeItemsVM(application: Application): AndroidViewModel(application) {

    private val homeItemsRepo = HomeItemsRepo()

    private var homeItemsList = MutableLiveData<List<Clickable?>>()
    fun getHomeItems(): MutableLiveData<List<Clickable?>> = this.homeItemsList

    init {
        homeItemsList = homeItemsRepo.getHomeItems()
    }
}