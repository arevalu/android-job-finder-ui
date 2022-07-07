package com.larevalo.jobfinder.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

private const val DEFAULT_COMPANY_LOGO = "logo_no_company"

@Parcelize
data class Job(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("position")
    val position: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("isFavorite")
    val isFavorite: Boolean = false,
    @SerializedName("salary")
    val salary: String = "",
    @SerializedName("salaryCurrency")
    val salaryCurrency: String = "",
    @SerializedName("company")
    val company: String = "",
    @SerializedName("workingHours")
    val workingHours: WorkingHours = WorkingHours.FLEXIBLE,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("companyLogo")
    val companyLogo: String? = DEFAULT_COMPANY_LOGO,
) : Parcelable {
    enum class WorkingHours {
        FLEXIBLE, PART_TIME
    }
}