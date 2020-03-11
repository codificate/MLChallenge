package com.candidate.servando.search.core.domain

data class AvailableFilter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<ValuesAvailableFilter>
)