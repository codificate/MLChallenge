package com.candidate.servando.search.core.domain

data class Filter(
    val id: String,
    val name: String,
    val type: String,
    val values: List<ValuesFilter>
)