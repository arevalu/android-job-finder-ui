package com.larevalo.jobfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.larevalo.jobfinder.databinding.ActivityMainBinding
import com.larevalo.jobfinder.model.Job
import com.larevalo.jobfinder.utils.JobItemDecorator

private const val JOB_ITEM_SPACING = 64

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainJobList.addItemDecoration(JobItemDecorator(JOB_ITEM_SPACING))
        binding.mainJobList.layoutManager = GridLayoutManager(this,1)

        val adapter = JobAdapter(this)
        binding.mainJobList.adapter = adapter

        val jobs = listOf(
            Job(
                "1",
                "Frontend Engineer",
                "Buenos Aires",
                false,
                "400.000",
                "Uber",
                Job.WorkingHours.FLEXIBLE,
                "Description of the position",
                "logo_uber",
            ),
            Job(
                "1",
                "Frontend Engineer",
                "Buenos Aires",
                true,
                "400.000",
                "Udemy",
                Job.WorkingHours.FLEXIBLE,
                "Description of the position",
                "logo_udemy",
            ),
            Job(
                "1",
                "Frontend Engineer",
                "Buenos Aires",
                false,
                "400.000",
                "Udemy",
                Job.WorkingHours.FLEXIBLE,
                "Description of the position",
                "logo_udemy",
            ),
            Job(
                "1",
                "Frontend Engineer",
                "Buenos Aires",
                false,
                "400.000",
                "Udemy",
                Job.WorkingHours.FLEXIBLE,
                "Description of the position"
            ),
            Job(
                "1",
                "Frontend Engineer",
                "Buenos Aires",
                false,
                "400.000",
                "Udemy",
                Job.WorkingHours.FLEXIBLE,
                "Description of the position",
                "logo_udemy",
            ),
            Job(
                "1",
                "Frontend Engineer",
                "Buenos Aires",
                false,
                "400.000",
                "Udemy",
                Job.WorkingHours.FLEXIBLE,
                "Description of the position",
                "logo_udemy",
            )
        )

        adapter.submitList(jobs)
    }
}