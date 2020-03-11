package com.candidate.servando.search.di.mapper

import com.candidate.servando.search.core.domain.*
import com.candidate.servando.search.infrastructure.representation.SearchResultResponse

fun SearchResultResponse.toSearchResult(): SearchResult {
    return SearchResult(
        available_filters = this.available_filters
            .map {
                AvailableFilter(
                    it.id, it.name,
                    it.type, it.valuesAvailableFilters
                        .map { values ->
                            ValuesAvailableFilter(
                                values.id, values.name, values.results
                            )
                        })
            },
        available_sorts = this.available_sorts
            .map { AvailableSort(it.id, it.name) },
        filters = this.filters
            .map {
                Filter(it.id, it.name, it.type, it.values
                    .map { values ->
                        ValuesFilter(values.id,
                            values.name,
                            values.path_from_root.map { path ->
                                PathFromRoot(
                                    path.id,
                                    path.name
                                )
                            })
                    })
            },
        paging = Paging(
            this.paging.limit,
            this.paging.offset,
            this.paging.primary_results,
            this.paging.total
        ),
        site_id = this.site_id,
        sort = Sort(this.sort.id, this.sort.name),
        items = this.results.map { result ->
            Item(
                accepts_mercadopago = result.accepts_mercadopago,
                address = Address(
                    result.address.city_id.orEmpty(), result.address.city_name.orEmpty(),
                    result.address.state_id.orEmpty(), result.address.state_name.orEmpty()
                ),
                available_quantity = result.available_quantity,
                buying_mode = result.buying_mode.orEmpty(),
                catalog_listing = result.catalog_listing,
                catalog_product_id = result.catalog_product_id.orEmpty(),
                site_id = result.site_id.orEmpty(),
                category_id = result.category_id.orEmpty(),
                condition = result.condition.orEmpty(),
                currency_id = result.currency_id.orEmpty(),
                differential_pricing = DifferentialPricing(
                    result.differential_pricing.id
                ),
                id = result.id.orEmpty(),
                installments = Installments(
                    result.installments.amount, result.installments.currency_id.orEmpty(),
                    result.installments.quantity, result.installments.rate
                ),
                listing_type_id = result.listing_type_id.orEmpty(),
                official_store_id = result.official_store_id,
                original_price = result.original_price,
                permalink = result.permalink.orEmpty(),
                price = result.price,
                seller = Seller(
                    result.seller.car_dealer,
                    result.seller.id,
                    result.seller.permalink.orEmpty(),
                    result.seller.power_seller_status.orEmpty(),
                    result.seller.real_estate_agency,
                    result.seller.tags
                ),
                seller_address = SellerAddress(
                    result.seller_address.address_line.orEmpty(),
                    City(
                        result.seller_address.city.id.orEmpty(),
                        result.seller_address.city.name.orEmpty()
                    ),
                    result.seller_address.comment.orEmpty(),
                    Country(
                        result.seller_address.country.id.orEmpty(),
                        result.seller_address.country.name.orEmpty()
                    ),
                    result.seller_address.id.orEmpty(),
                    result.seller_address.latitude.orEmpty(),
                    result.seller_address.longitude.orEmpty(),
                    State(
                        result.seller_address.state.id.orEmpty(),
                        result.seller_address.state.name.orEmpty()
                    ),
                    result.seller_address.zip_code.orEmpty()
                ),
                shipping = Shipping(
                    result.shipping.free_shipping,
                    result.shipping.logistic_type.orEmpty(),
                    result.shipping.mode.orEmpty(),
                    result.shipping.store_pick_up,
                    result.shipping.tags.map { tag: String? -> tag.orEmpty() }
                ),
                sold_quantity = result.sold_quantity,
                stop_time = result.stop_time.orEmpty(),
                tags = result.tags.map { tag: String? -> tag.orEmpty() },
                thumbnail = result.thumbnail.orEmpty(),
                title = result.title.orEmpty()
            )
        }
    )
}