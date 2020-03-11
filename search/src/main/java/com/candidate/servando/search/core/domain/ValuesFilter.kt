package com.candidate.servando.search.core.domain

data class ValuesFilter(
    val id: String,
    val name: String,
    val path_from_root: List<PathFromRoot>
)