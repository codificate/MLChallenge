package com.candidate.servando.search.infrastructure.client

import com.candidate.servando.search.infrastructure.representation.CategoriesResponse
import com.candidate.servando.search.infrastructure.representation.SearchResultResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("categories")
    fun categories(): Single<List<CategoriesResponse>>

    @GET("search")
    fun findResults(@Query("q") query: String?,
                    @Query("category") category: String?): Single<SearchResultResponse>

}