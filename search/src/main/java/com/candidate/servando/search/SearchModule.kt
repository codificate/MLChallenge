package com.candidate.servando.search

import com.candidate.servando.search.core.actions.SearchProduct
import com.candidate.servando.search.di.SearchServiceCreator
import com.candidate.servando.search.ui.widget.CategoriesReactionPublisher

object SearchModule {

    fun categoryReaction() = CategoriesReactionPublisher

    fun searchAction() = SearchProduct(SearchServiceCreator.create())

}

