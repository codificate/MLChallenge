package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)