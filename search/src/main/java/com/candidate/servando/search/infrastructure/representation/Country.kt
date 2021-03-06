package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
): Serializable