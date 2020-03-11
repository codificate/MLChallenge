package com.candidate.servando.search.core.actions

import com.candidate.servando.search.core.domain.Category
import com.candidate.servando.search.infrastructure.representation.CategoriesResponse
import com.candidate.servando.search.infrastructure.service.SearchService
import io.reactivex.Single


class FetchCategories(private val searchService: SearchService) {

    operator fun invoke(): Single<List<Category>> {
        return searchService.fetchCategories()
            .onErrorReturn { DEFAULT_SUBJECTS }
            .map { categories -> categories.map { Category(it.id, it.name) } }
    }

    private val DEFAULT_SUBJECTS = emptyList<CategoriesResponse>()
}