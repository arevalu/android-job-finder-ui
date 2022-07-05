package com.larevalo.jobfinder.model

private const val DEFAULT_COMPANY_LOGO = "logo_no_company"

data class Job(
    val id: String,
    val position: String,
    val location: String,
    val isFavorite: Boolean,
    val salary: String,
    val company: String,
    val workingHours: WorkingHours,
    val description: String,
    val companyLogo: String? = DEFAULT_COMPANY_LOGO,
) {
    enum class WorkingHours {
        FLEXIBLE, PART_TIME
    }
}