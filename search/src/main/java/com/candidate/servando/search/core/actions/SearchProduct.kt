package com.candidate.servando.search.core.actions

import io.reactivex.Single
import com.candidate.servando.search.core.domain.*
import com.candidate.servando.search.di.mapper.toSearchResult
import com.candidate.servando.search.infrastructure.service.SearchService

class SearchProduct(private val searchService: SearchService) {

    operator fun invoke(product: String?, category: String?): Single<SearchResult> {
        return searchService.makeSearch(product, category)
            .map { it.toSearchResult() }
    }
}

