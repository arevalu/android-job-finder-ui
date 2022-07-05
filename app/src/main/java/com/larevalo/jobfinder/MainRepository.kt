package com.larevalo.jobfinder

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.larevalo.jobfinder.model.Job
import com.larevalo.jobfinder.utils.getJSONFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val JOBS_FILE = "jobs.json"

class JobRepository(context: Context) {
    private val gson = Gson()
    private val file = getJSONFile(context, JOBS_FILE)

    suspend fun fetchJobs(): MutableList<Job> {
        return withContext(Dispatchers.IO) {
            val typeToken = object : TypeToken<List<Job>>() {}.type

            val jobJSON = gson.fromJson<List<Job>>(file, typeToken)
            parseResult(jobJSON)
        }
    }

    private fun parseResult(jobResponse: List<Job>): MutableList<Job> {
        val jobList = mutableListOf<Job>()

        for (job in jobResponse) {
            jobList.add(job)
        }

        return jobList
    }
}