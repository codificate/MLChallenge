package com.candidate.servando

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.candidate.servando.sharedresources.hideKeyboard
import com.candidate.servando.viewmodel.MainActivityViewModel
import com.candidate.servando.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by lazy { MainActivityViewModelFactory.create(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.items.observe(this, Observer {

        })
    }

    private fun setListeners() {
        categoriesButton.setOnClickListener {
            hideKeyboard()
            categoriesList.makeVisible()
        }

        searchButton.setOnClickListener {
            hideKeyboard()
            categoriesList.hide()
        }
    }
}
