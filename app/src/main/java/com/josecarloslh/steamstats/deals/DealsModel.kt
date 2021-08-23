package com.josecarloslh.steamstats.deals

import com.josecarloslh.steamstats.utils.FloatFormatter

data class DealsModel(
    var title: String,
    var discountPercentage: Float,
    var salePrice: Float,
    var normalPrice: Float,
    var metacriticRating: Int,
    var steamRating: Int,
    var thumb: String
) {
    val salePriceFormatted: String
        get() = FloatFormatter.formatPrice(salePrice)

    val normalPriceFormatted: String
        get() = FloatFormatter.formatPrice(normalPrice)

    val discountPercentageFormatted: String
        get() = FloatFormatter.formatPrice(discountPercentage)
}
