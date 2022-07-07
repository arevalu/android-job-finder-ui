package com.larevalo.jobfinder

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.larevalo.jobfinder.databinding.FragmentJobDetailModalBinding
import com.larevalo.jobfinder.model.Job
import com.larevalo.jobfinder.utils.convertStringToDrawableResource

private const val MODAL_HEIGHT_PERCENTAGE = 85
private const val MODAL_CONTENT_HEIGHT_PERCENTAGE = 75

class JobDetailModalFragment : BottomSheetDialogFragment() {
    private val args: JobDetailModalFragmentArgs by navArgs()
    private lateinit var binding: FragmentJobDetailModalBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<RelativeLayout>
    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.Theme_Modal)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return (super.onCreateDialog(savedInstanceState) as BottomSheetDialog).apply {
            behavior.setPeekHeight(getModalHeight(MODAL_HEIGHT_PERCENTAGE), true)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJobDetailModalBinding.inflate(inflater)
        job = args.job

        binding.detailContentWrapper.layoutParams.height = getModalHeight(MODAL_CONTENT_HEIGHT_PERCENTAGE)
        bottomSheetBehavior = BottomSheetBehavior.from(binding.jobDetailBottomSheet)

        setBottomSheetVisibility(true)
        handleData(job)

        return binding.root
    }

    private fun handleData(job: Job) {
        binding.detailCompanyLogo.setImageResource(convertStringToDrawableResource(requireContext(), job.companyLogo))

        binding.detailPosition.text = job.position
        binding.detailLocation.text = job.location
        binding.detailCompanyName.text = job.company
        binding.detailCompanySalary.text = requireContext().getString(R.string.format_job_salary, job.salary, job.salaryCurrency)
        binding.detailCompanyWorkingHours.text = job.workingHours.toString()
        binding.detailDescription.text = job.description
    }

    private fun getModalHeight(percentage: Int): Int {
        return (getDeviceHeight() * percentage) / 100
    }

    private fun getDeviceHeight(): Int {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            return requireActivity().display!!.mode.physicalHeight
        }
        @Suppress("DEPRECATION")
        return requireActivity().windowManager.defaultDisplay.mode.physicalHeight
    }

    private fun setBottomSheetVisibility(isVisible: Boolean) {
        val updatedState =
            if (isVisible) BottomSheetBehavior.STATE_EXPANDED else BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.state = updatedState
    }
}