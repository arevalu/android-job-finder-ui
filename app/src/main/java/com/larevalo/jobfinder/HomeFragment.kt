package com.larevalo.jobfinder

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.larevalo.jobfinder.databinding.FragmentHomeBinding
import com.larevalo.jobfinder.model.Job
import com.larevalo.jobfinder.utils.JobItemDecorator

private const val JOB_ITEM_SPACING = 64

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    interface JobSelectListener {
        fun onJobSelected(job: Job)
    }

    private lateinit var jobSelectListener: JobSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        jobSelectListener = try {
            context as JobSelectListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement JobSelectListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        val adapter = MainAdapter(requireActivity())

        binding.mainJobList.addItemDecoration(JobItemDecorator(JOB_ITEM_SPACING))
        binding.mainJobList.layoutManager = GridLayoutManager(requireActivity(), 1)
        binding.mainJobList.adapter = adapter

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        viewModel.jobList.observe(requireActivity()) { jobList ->
            adapter.submitList(jobList)
        }

        adapter.onItemClickListener = { job ->
            jobSelectListener.onJobSelected(job)
        }

        return binding.root
    }

}