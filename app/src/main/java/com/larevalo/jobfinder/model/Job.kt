package com.larevalo.jobfinder.model

data class Job(
    val id: String,
    val position: String,
    val location: String,
    val isFavorite: Boolean,
    val salary: String,
    val company: String,
    val companyLogo: String,
    val workingHours: WorkingHours,
    val description: String
) {
    enum class WorkingHours {
        FLEXIBLE, PART_TIME
    }
}