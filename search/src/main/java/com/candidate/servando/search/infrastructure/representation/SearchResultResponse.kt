package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchResultResponse(
    @SerializedName("available_filters")
    val available_filters: List<AvailableFilter>,
    @SerializedName("available_sorts")
    val available_sorts: List<AvailableSort>,
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("related_results")
    val related_results: List<Any?>,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("secondary_results")
    val secondary_results: List<Any?>,
    @SerializedName("site_id")
    val site_id: String,
    @SerializedName("sort")
    val sort: Sort
): Serializable
