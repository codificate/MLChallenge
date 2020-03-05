package com.candidate.servando.search.infrastructure.representation

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Result(
    @SerializedName("accepts_mercadopago")
    val accepts_mercadopago: Boolean,
    @SerializedName("address")
    val address: Address,
    @SerializedName("attributes")
    val attributes: List<Attribute>,
    @SerializedName("available_quantity")
    val available_quantity: Int,
    @SerializedName("buying_mode")
    val buying_mode: String?,
    @SerializedName("catalog_listing")
    val catalog_listing: Boolean,
    @SerializedName("catalog_product_id")
    val catalog_product_id: String?,
    @SerializedName("category_id")
    val category_id: String?,
    @SerializedName("condition")
    val condition: String?,
    @SerializedName("currency_id")
    val currency_id: String?,
    @SerializedName("differential_pricing")
    val differential_pricing: DifferentialPricing,
    @SerializedName("id")
    val id: String?,
    @SerializedName("installments")
    val installments: Installments,
    @SerializedName("listing_type_id")
    val listing_type_id: String?,
    @SerializedName("official_store_id")
    val official_store_id: Int,
    @SerializedName("original_price")
    val original_price: Int,
    @SerializedName("permalink")
    val permalink: String?,
    @SerializedName("price")
    val price: Int,
    @SerializedName("seller")
    val seller: Seller,
    @SerializedName("seller_address")
    val seller_address: SellerAddress,
    @SerializedName("shipping")
    val shipping: Shipping,
    @SerializedName("site_id")
    val site_id: String?,
    @SerializedName("sold_quantity")
    val sold_quantity: Int,
    @SerializedName("stop_time")
    val stop_time: String?,
    @SerializedName("tags")
    val tags: List<String?>,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("title")
    val title: String?
): Serializable