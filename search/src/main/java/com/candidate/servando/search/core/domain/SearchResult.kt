package com.candidate.servando.search.core.domain

data class SearchResult(
    val available_filters: List<AvailableFilter>,
    val available_sorts: List<AvailableSort>,
    val filters: List<Filter>,
    val items: List<Item>,
    val site_id: String,
    val paging: Paging,
    val sort: Sort
)