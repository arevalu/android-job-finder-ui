package com.larevalo.jobfinder.utils

import android.content.Context

fun getJSONFile(context: Context, file: String): String {
    return context.assets.open(file).bufferedReader().use { it.readText() }
}

fun convertStringToDrawableResource(context: Context, companyLogo: String?): Int {
    return context.resources.getIdentifier(companyLogo, "drawable", context.packageName)
}