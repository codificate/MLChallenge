package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName

data class ValuesFilter(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("path_from_root")
    val path_from_root: List<PathFromRoot>
)