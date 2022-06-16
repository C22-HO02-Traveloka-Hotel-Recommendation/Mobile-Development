package com.company.project.traveloka.utils

import android.view.View

object Utils {
    fun isLoading(status: Boolean, view: View) {
        if (status) view.visibility = View.VISIBLE
        else view.visibility = View.INVISIBLE
    }
}
