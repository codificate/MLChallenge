package com.candidate.servando.search.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.candidate.servando.search.core.actions.FetchCategories
import com.candidate.servando.search.core.domain.Category
import com.candidate.servando.sharedresources.onDefaultSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class CategoriesViewModel(private val fetchCategories: FetchCategories) : ViewModel()  {


    private val subscriptions = CompositeDisposable()
    private var mutableListCategories= MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = mutableListCategories

    init {
        fetchCategories()
            .onDefaultSchedulers()
            .subscribeBy( onSuccess = ::setCategoryList )
            .addTo(subscriptions)
    }

    private fun setCategoryList(list: List<Category>) {
        mutableListCategories.postValue(list)
    }

}
