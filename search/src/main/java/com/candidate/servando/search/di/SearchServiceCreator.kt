package com.candidate.servando.search.di

import com.candidate.servando.search.infrastructure.service.SearchService

object SearchServiceCreator {
    fun create() = SearchService(SearchClientCreator.create())
}