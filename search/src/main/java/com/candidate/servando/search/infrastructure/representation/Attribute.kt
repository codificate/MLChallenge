package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("attribute_group_id")
    val attribute_group_id: String?,
    @SerializedName("attribute_group_name")
    val attribute_group_name: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("source")
    val source: Int,
    @SerializedName("value_id")
    val value_id: String?,
    @SerializedName("value_name")
    val value_name: String?,
    @SerializedName("value_struct")
    val value_struct: Any?,
    @SerializedName("values")
    val values: List<ValuesAttribute>
)