package com.candidate.servando.viewmodel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.candidate.servando.search.SearchModule

object MainActivityViewModelFactory {

    internal fun create(fragment: FragmentActivity): MainActivityViewModel {
        return ViewModelProviders.of(fragment, createFactory()).get(MainActivityViewModel::class.java)
    }

    @Suppress("UNCHECKED_CAST")
    private fun createFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainActivityViewModel(SearchModule.categoryReaction(),
                    SearchModule.searchAction()) as T
            }
        }
    }

}