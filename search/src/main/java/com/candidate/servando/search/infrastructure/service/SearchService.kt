package com.candidate.servando.search.infrastructure.service

import com.candidate.servando.search.infrastructure.client.SearchApi
import com.candidate.servando.search.infrastructure.representation.SearchResultResponse
import io.reactivex.Single

class SearchService(private val searchApi: SearchApi) {

    fun fetchCategories() = searchApi.categories()

    fun makeSearch(lookingFor: String?, category: String?): Single<SearchResultResponse> {
        return searchApi.findResults(lookingFor, category)
    }

}