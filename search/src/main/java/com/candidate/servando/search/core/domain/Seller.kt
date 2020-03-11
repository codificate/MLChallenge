package com.candidate.servando.search.core.domain

data class Seller(
    val car_dealer: Boolean,
    val id: Int,
    val permalink: String,
    val power_seller_status: String,
    val real_estate_agency: Boolean,
    val tags: List<String?>
)