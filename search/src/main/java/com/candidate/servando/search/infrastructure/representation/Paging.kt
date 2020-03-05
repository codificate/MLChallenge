package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Paging(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("primary_results")
    val primary_results: Int,
    @SerializedName("total")
    val total: Int
): Serializable