package com.josecarloslh.steamstats.mostowned

import com.josecarloslh.steamstats.utils.FloatFormatter

data class MostOwnedModel(
    var title: String,
    var owners: Int,
    var steamRating: Int,
    var price: Float,
    var position: Int,
    var thumb: String
) {
    val priceFormatted: String
        get() = FloatFormatter.formatPrice(price)
}