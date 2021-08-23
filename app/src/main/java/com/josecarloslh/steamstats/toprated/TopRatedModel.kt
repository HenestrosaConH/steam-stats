package com.josecarloslh.steamstats.toprated

import com.josecarloslh.steamstats.utils.FloatFormatter

data class TopRatedModel(
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