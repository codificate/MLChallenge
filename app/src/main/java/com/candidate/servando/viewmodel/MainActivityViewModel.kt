package com.candidate.servando.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.addTo
import androidx.lifecycle.ViewModel
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.disposables.CompositeDisposable
import com.candidate.servando.search.core.domain.SearchResult
import com.candidate.servando.search.core.actions.SearchProduct
import com.candidate.servando.search.core.domain.Item
import com.candidate.servando.sharedresources.onDefaultSchedulers
import com.candidate.servando.search.ui.widget.CategoriesReactionPublisher

class MainActivityViewModel(
    private val categoryReaction: CategoriesReactionPublisher,
    private val searchProduct: SearchProduct
) : ViewModel() {

    private val subscriptions = CompositeDisposable()
    private val mutableListItem = MutableLiveData<List<Item>>()
    val items = mutableListItem

    init {
        categoryReaction.observe()
            .onDefaultSchedulers()
            .subscribeBy(onNext = { onCategoryClicked(it) }, onError = {  })
            .addTo(subscriptions)
    }

    private fun onCategoryClicked(categoryId: String) {
        searchProduct("", categoryId)
            .onDefaultSchedulers()
            .subscribeBy(onSuccess = ::onReceiveItems)
            .addTo(subscriptions)
    }

    fun onReceiveItems(searchResult: SearchResult) {
        mutableListItem.postValue(searchResult.items.slice(IntRange(0, 50)))
    }
}