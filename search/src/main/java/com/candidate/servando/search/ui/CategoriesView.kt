package com.candidate.servando.search.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.candidate.servando.search.R
import androidx.fragment.app.FragmentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class CategoriesView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val owner: FragmentActivity by lazy {
        return@lazy try {
            context as FragmentActivity
        } catch (exception: ClassCastException) {
            throw ClassCastException("Please ensure that the provided Context is a valid Fragment")
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.categories_view, this, true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

}