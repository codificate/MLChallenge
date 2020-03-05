package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName

data class ValuesAttribute(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("source")
    val source: Int,
    @SerializedName("struct")
    val struct: Any?
)