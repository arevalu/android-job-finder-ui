package com.larevalo.jobfinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.larevalo.jobfinder.model.Job

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var _jobList = MutableLiveData<MutableList<Job>>()
    val jobList: LiveData<MutableList<Job>>
        get() = _jobList
}