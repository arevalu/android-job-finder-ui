package com.larevalo.jobfinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.larevalo.jobfinder.model.Job
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var _jobList = MutableLiveData<MutableList<Job>>()
    val jobList: LiveData<MutableList<Job>>
        get() = _jobList

    private val repository = JobRepository(application)

    init {
        getJobs()
    }

    private fun getJobs() {
        viewModelScope.launch {
            _jobList.value = repository.fetchJobs()
        }
    }
}