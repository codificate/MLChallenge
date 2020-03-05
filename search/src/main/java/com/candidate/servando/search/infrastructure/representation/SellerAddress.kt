package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SellerAddress(
    @SerializedName("address_line")
    val address_line: String?,
    @SerializedName("city")
    val city: City,
    @SerializedName("comment")
    val comment: String?,
    @SerializedName("country")
    val country: Country,
    @SerializedName("id")
    val id: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longitude")
    val longitude: String?,
    @SerializedName("state")
    val state: State,
    @SerializedName("zip_code")
    val zip_code: String?
): Serializable