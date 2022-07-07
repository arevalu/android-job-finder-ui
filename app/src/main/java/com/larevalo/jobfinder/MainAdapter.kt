package com.larevalo.jobfinder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.larevalo.jobfinder.databinding.JobItemBinding
import com.larevalo.jobfinder.model.Job
import com.larevalo.jobfinder.utils.convertStringToDrawableResource

class MainAdapter(private val context: Context) :
    ListAdapter<Job, MainAdapter.JobViewHolder>(DiffCallback) {
    lateinit var onItemClickListener: (Job) -> Unit

    companion object DiffCallback : DiffUtil.ItemCallback<Job>() {
        override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = JobItemBinding.inflate(LayoutInflater.from(parent.context))
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = getItem(position)
        holder.bind(job)
    }

    inner class JobViewHolder(private val binding: JobItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(job: Job) {
            binding.jobItemPosition.text = job.position
            binding.jobItemSalary.text =
                context.getString(R.string.format_job_salary, job.salary, job.salaryCurrency)
            binding.jobItemLocation.text = job.location
            binding.jobItemLogo.setImageResource(convertStringToDrawableResource(context, job.companyLogo))

            if (job.isFavorite) {
                formatFavoriteJobItem(binding)
            }

            if (::onItemClickListener.isInitialized) {
                binding.root.setOnClickListener{ onItemClickListener(job) }
            }
        }
    }

    private fun formatFavoriteJobItem(binding: JobItemBinding) {
        binding.jobItem.background =
            AppCompatResources.getDrawable(context, R.drawable.shape_job_featured_item)
        binding.jobItemPosition.setTextColor(ContextCompat.getColor(context, R.color.white))
        binding.jobItemSalary.setTextColor(ContextCompat.getColor(context, R.color.white))
        binding.jobItemLocation.setTextColor(ContextCompat.getColor(context, R.color.favorite_text))
        binding.jobItemLocationIcon.isSelected = true
    }
}