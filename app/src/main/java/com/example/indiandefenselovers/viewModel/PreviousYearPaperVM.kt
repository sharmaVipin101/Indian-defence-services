package com.example.indiandefenselovers.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.indiandefenselovers.repository.model.Clickable
import com.example.indiandefenselovers.repository.model.Paper
import com.example.indiandefenselovers.repository.network.PapersRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PreviousYearPaperVM(application: Application): AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO + Job() )
    private var papersRepo: PapersRepo = PapersRepo()

    private var activePapersList =  MutableLiveData<List<Paper?>>()
    fun getPapersList(data: Clickable): MutableLiveData<List<Paper?>> {
        activePapersList = papersRepo.getPapersData(data)
        return activePapersList
    }
}