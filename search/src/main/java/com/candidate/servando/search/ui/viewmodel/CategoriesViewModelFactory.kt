package com.candidate.servando.search.ui.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.candidate.servando.search.core.actions.FetchCategories
import com.candidate.servando.search.di.SearchServiceCreator

object CategoriesViewModelFactory {

    internal fun create(fragment: FragmentActivity): CategoriesViewModel {
        return ViewModelProviders.of(fragment, createFactory()).get(CategoriesViewModel::class.java)
    }

    @Suppress("UNCHECKED_CAST")
    private fun createFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CategoriesViewModel(FetchCategories(SearchServiceCreator.create())) as T
            }
        }
    }
}