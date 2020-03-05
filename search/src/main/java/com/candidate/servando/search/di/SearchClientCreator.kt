package com.candidate.servando.search.di

import com.candidate.servando.rest.RestModule
import com.candidate.servando.search.BuildConfig
import com.candidate.servando.search.infrastructure.client.SearchApi

object SearchClientCreator {
    fun create(): SearchApi {
        return RestModule.createApi(
            RestModule.createHttpClient(emptyList()),
            SearchApi::class.java,
            BuildConfig.BASE_URL
        )
    }
}