package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName

data class Installments(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency_id")
    val currency_id: String?,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("rate")
    val rate: Double
)