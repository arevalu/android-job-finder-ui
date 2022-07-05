package com.larevalo.jobfinder.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class JobItemDecorator(private val verticalSpacing: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildLayoutPosition(view) != 0) {
            outRect.top= verticalSpacing
        }
    }

}