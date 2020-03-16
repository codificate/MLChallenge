package com.candidate.servando.search.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import com.candidate.servando.search.R
import androidx.fragment.app.FragmentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.candidate.servando.search.ui.viewmodel.CategoriesViewModel
import com.candidate.servando.search.ui.viewmodel.CategoriesViewModelFactory
import kotlinx.android.synthetic.main.categories_view.view.*

class CategoriesView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val owner: FragmentActivity by lazy {
        return@lazy try {
            context as FragmentActivity
        } catch (exception: ClassCastException) {
            throw ClassCastException("Please ensure that the provided Context is a valid Fragment")
        }
    }

    private val viewModel: CategoriesViewModel by lazy { CategoriesViewModelFactory.create(owner) }
    val layoutManager = LinearLayoutManager(owner)

    init {
        LayoutInflater.from(context).inflate(R.layout.categories_view, this, true)
    }

    fun makeVisible(){
        this@CategoriesView.visibility = View.VISIBLE
    }

    fun hide(){
        this@CategoriesView.visibility = View.GONE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setLayoutManager()
        viewModel.categories.observe(owner, Observer {
            categoriesRecycler.adapter = CategoriesAdapter(it)
        })
    }

    private fun setLayoutManager() {
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        categoriesRecycler.layoutManager = layoutManager
    }

}