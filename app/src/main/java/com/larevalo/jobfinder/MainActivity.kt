package com.larevalo.jobfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.larevalo.jobfinder.databinding.ActivityMainBinding
import com.larevalo.jobfinder.utils.JobItemDecorator

private const val JOB_ITEM_SPACING = 64

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.mainJobList.addItemDecoration(JobItemDecorator(JOB_ITEM_SPACING))
        binding.mainJobList.layoutManager = GridLayoutManager(this, 1)

        val adapter = MainAdapter(this)
        binding.mainJobList.adapter = adapter

        viewModel.jobList.observe(this) { jobList ->
            adapter.submitList(jobList)
        }
    }
}